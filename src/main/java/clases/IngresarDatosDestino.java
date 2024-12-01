/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

   import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
public class IngresarDatosDestino {
 
public int ejecutarInsercion(Connection connDes, Connection connOrg, String consultaPreparada, 
                             String tableOrigen, boolean fromTable, ArrayList<String> camposOrigen) {
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
                    System.err.println("Error al establecer parámetro para la columna " + i + " (" + rsOrg.getMetaData().getColumnName(i) + "): " + e.getMessage());
                    e.printStackTrace(); // Mostrar detalles del error
                }
            }

            // Ejecutar la inserción y contar filas afectadas
            int filasAfectadas = stmtInsert.executeUpdate();

            if (filasAfectadas > 0) {
                cantInsert++;
                System.out.println("Inserción exitosa para la fila, filas afectadas: " + filasAfectadas);
            } else {
                System.err.println("No se insertaron filas en esta iteración.");
            }
        }
    } catch (SQLException e) {
        System.err.println("Error ejecutando inserción: " + e.getMessage());
        e.printStackTrace(); // Mostrar detalles completos del error
    }

    // Devolver la cantidad de inserciones realizadas
    System.out.println("Cantidad de inserciones realizadas: " + cantInsert);
    return cantInsert;
}















}
