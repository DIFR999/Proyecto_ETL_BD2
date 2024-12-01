/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

   import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
public class IngresarDatosDestino {
 
public String prepararInsercion(Connection connOrg, ArrayList<String> camposDestino,
                                ArrayList<String> camposOrigen, String tableOrigen, 
                                String tableDestino, boolean fromTable) {

    String consultaPreparada = null;
    ResultSet rsOrg = null;

    try {
        // Validar que las listas de campos no estén vacías y que coincidan en tamaño
        if (camposDestino.isEmpty() || camposOrigen.isEmpty()) {
            throw new IllegalArgumentException("Las listas de campos de origen y destino no pueden estar vacías.");
        }
        if (camposDestino.size() != camposOrigen.size()) {
            throw new IllegalArgumentException("El número de campos de origen y destino debe coincidir.");
        }

        // Construir la lista de campos de la consulta SELECT
        StringBuilder camposConsulta = new StringBuilder();
        for (String campo : camposOrigen) {
            camposConsulta.append(campo).append(", ");
        }
        camposConsulta.delete(camposConsulta.length() - 2, camposConsulta.length()); // Quitar la última coma y espacio

        // Generar la consulta de origen
        String sqlOrigen;
        if (fromTable) {
            // Si el origen es una tabla, usar SELECT directo
            sqlOrigen = "SELECT " + camposConsulta.toString() + " FROM " + tableOrigen;
        } else {
            // Si el origen es una consulta directa
            sqlOrigen = tableOrigen; // Aquí `tableOrigen` contiene la consulta personalizada
        }

        // Validar la consulta de origen ejecutándola
        PreparedStatement stmtOrg = connOrg.prepareStatement(sqlOrigen);
        rsOrg = stmtOrg.executeQuery();

        // Verificar si la consulta de origen devuelve algún resultado
        if (!rsOrg.isBeforeFirst()) {
            throw new SQLException("No se encontraron datos en la consulta de origen.");
        }

        // Construir las condiciones para la cláusula EXISTS usando ?
        StringBuilder condicionesExists = new StringBuilder();
        for (int i = 0; i < camposDestino.size(); i++) {
            condicionesExists.append(tableDestino).append(".").append(camposDestino.get(i))
                             .append(" = ? AND ");
        }
        condicionesExists.delete(condicionesExists.length() - 5, condicionesExists.length()); // Quitar " AND"

        // Construir la consulta final
        consultaPreparada = "INSERT INTO " + tableDestino + " (" + String.join(", ", camposDestino) + ") " +
                            "SELECT " + String.join(", ", camposOrigen) + " " +
                            "FROM (" + sqlOrigen + ") subquery " +  // Quitamos AS
                            "WHERE NOT EXISTS (" +
                            "SELECT 1 FROM " + tableDestino +
                            " WHERE " + condicionesExists + ")";

    } catch (SQLException e) {
        System.out.println("Error al preparar la consulta de inserción: " + e.getMessage());
        e.printStackTrace(); // Agregar traza completa para depurar errores SQL
    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    }

    // Imprimir la consulta generada para depuración
    System.out.println("Consulta preparada: " + consultaPreparada);
    return consultaPreparada;
}


public int ejecutarInsercion(Connection connDes, Connection connOrg, String consultaPreparada, 
                             String tableOrigen, boolean fromTable, ArrayList<String> camposOrigen) throws SQLException {
    int cantInsert = 0;
    String ConsultaDesdeFROM = null;
    int indexFrom = tableOrigen.toUpperCase().indexOf("FROM");
    if (indexFrom != -1) {
        ConsultaDesdeFROM = tableOrigen.substring(indexFrom); // Retorna la parte de la consulta a partir de "FROM"
    }
    
    try (PreparedStatement stmtOrg = connOrg.prepareStatement(
            fromTable ? "SELECT " + String.join(", ", camposOrigen) + " FROM " + tableOrigen 
                      : "SELECT " + String.join(", ", camposOrigen) + " " + ConsultaDesdeFROM);
         ResultSet rsOrg = stmtOrg.executeQuery();
         PreparedStatement stmtInsert = connDes.prepareStatement(consultaPreparada)) {

        // Verificar cuántas columnas tiene el ResultSet
        int columnCount = rsOrg.getMetaData().getColumnCount();

        // Si no hay datos en el ResultSet, regresar 0
        if (!rsOrg.isBeforeFirst()) {
            return 0;
        }

        // Iterar sobre los resultados de la consulta de origen
        while (rsOrg.next()) {

            // Iterar por todas las columnas
            for (int i = 1; i <= columnCount; i++) {
                try {
                    // Obtener el nombre de la columna
                    String columnName = rsOrg.getMetaData().getColumnName(i);
                    // Mostrar nombre de la columna y su valor
                    System.out.println("Columna: " + columnName + ", Valor: " + rsOrg.getObject(i));

                    // Verificar si el tipo de columna es DATE
                    if (rsOrg.getMetaData().getColumnType(i) == java.sql.Types.DATE) {
                        stmtInsert.setDate(i, rsOrg.getDate(i));
                    } else if (rsOrg.getMetaData().getColumnType(i) == java.sql.Types.TIMESTAMP) {
                        stmtInsert.setTimestamp(i, rsOrg.getTimestamp(i)); // Manejar tipo TIMESTAMP
                    } else {
                        stmtInsert.setObject(i, rsOrg.getObject(i)); // Otros tipos de datos
                    }
                } catch (SQLException e) {
                    // Mostrar el error con la columna específica que causó el problema
                    System.err.println("Error en la columna " + i + " (" + rsOrg.getMetaData().getColumnName(i) + "): " + e.getMessage());
                    e.printStackTrace(); // Mostrar detalles del error
                }
            }

            // Establecer los parámetros para la cláusula WHERE NOT EXISTS (ajustado según columnas esperadas)
            for (int i = 1; i <= camposOrigen.size(); i++) {
                try {
                    // Obtener el nombre de la columna del ResultSet y verificar el valor
                    String columnName = rsOrg.getMetaData().getColumnName(i);
                    System.out.println("Estableciendo parámetro para columna: " + columnName + ", Valor: " + rsOrg.getObject(i));

                    // Asegurarse de que los parámetros sean correctos según el tipo de columna
                    if (rsOrg.getMetaData().getColumnType(i) == java.sql.Types.TIMESTAMP) {
                        stmtInsert.setTimestamp(i, rsOrg.getTimestamp(i)); // Usar setTimestamp para columnas TIMESTAMP
                    } else if (rsOrg.getMetaData().getColumnType(i) == java.sql.Types.DATE) {
                        stmtInsert.setDate(i, rsOrg.getDate(i)); // Usar setDate para columnas DATE
                    } else {
                        stmtInsert.setObject(i, rsOrg.getObject(i)); // Para otros tipos de datos
                    }
                } catch (SQLException e) {
                    // Mostrar el error con la columna específica que causó el problema
                    
                      connDes.rollback();
                    System.err.println("Error al establecer parámetro para la columna " + i + " (" + rsOrg.getMetaData().getColumnName(i) + "): " + e.getMessage());
                    e.printStackTrace(); // Mostrar detalles del error
                }
            }

            // Ejecutar la inserción y contar filas afectadas
            int filasAfectadas = stmtInsert.executeUpdate();
                System.out.println("Cantidad de inserciones realizadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                cantInsert++;
                System.out.println("Inserción exitosa para la fila, filas afectadas: " + filasAfectadas);
            } else {
                System.err.println("No se insertaron filas en esta iteración.");
            }
            
            // Confirmar la transacción si todo es exitoso
            connDes.commit();
            
        }
    } catch (SQLException e) {
          connDes.rollback();
        System.err.println("Error ejecutando inserción: " + e.getMessage());
        e.printStackTrace(); // Mostrar detalles completos del error
    }

    // Devolver la cantidad de inserciones realizadas
    System.out.println("Cantidad de inserciones realizadas: " + cantInsert);
    return cantInsert;
}















}
