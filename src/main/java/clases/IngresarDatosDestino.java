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

    // Mensajes de depuración para ver los parámetros al inicio
    System.out.println("Conexión de destino: " + connDes);
    System.out.println("Conexión de origen: " + connOrg);
    System.out.println("Consulta preparada: " + consultaPreparada);
    System.out.println("Tabla de origen: " + tableOrigen);
    System.out.println("Desde tabla: " + fromTable);
    System.out.println("Campos de origen: " + camposOrigen);

    // Obtener la parte de la consulta desde "FROM"
    int indexFrom = tableOrigen.toUpperCase().indexOf("FROM");
    if (indexFrom != -1) {
        ConsultaDesdeFROM = tableOrigen.substring(indexFrom);
        System.out.println("Consulta desde 'FROM': " + ConsultaDesdeFROM);
    }

    // **Primera Parte: Crear la consulta para el origen**
    String consultaOrigen;
    if (fromTable) {
        consultaOrigen = "SELECT " + String.join(", ", camposOrigen) + " FROM " + tableOrigen;
    } else {
        consultaOrigen = "SELECT " + String.join(", ", camposOrigen) + " " + ConsultaDesdeFROM;
    }
    System.out.println("Consulta para origen: " + consultaOrigen);

    // Bloque try-with-resources para manejar los recursos
    try (PreparedStatement stmtOrg = connOrg.prepareStatement(consultaOrigen);
         ResultSet rsOrg = stmtOrg.executeQuery();
         PreparedStatement stmtInsert = connDes.prepareStatement(consultaPreparada)) {

        // **Segunda Parte: Verificar columnas en el ResultSet**
        int columnCount = rsOrg.getMetaData().getColumnCount();
        System.out.println("Número de columnas en el ResultSet: " + columnCount);

        // Si no hay datos, regresar 0
        if (!rsOrg.isBeforeFirst()) {
            System.out.println("No se encontraron filas en el ResultSet.");
            return 0;
        }

        // **Tercera Parte: Iterar sobre los resultados y realizar inserciones**
        while (rsOrg.next()) {
            System.out.println("Procesando una fila...");

            // Iterar por cada columna para insertar valores
            for (int i = 1; i <= columnCount; i++) {
                try {
                    String columnName = rsOrg.getMetaData().getColumnName(i);
                    System.out.println("Columna: " + columnName + ", Valor: " + rsOrg.getObject(i));
                    stmtInsert.setObject(i, rsOrg.getObject(i)); // Configurar valores
                } catch (SQLException e) {
                    System.err.println("Error en la columna " + i + " (" + rsOrg.getMetaData().getColumnName(i) + "): " + e.getMessage());
                    e.printStackTrace();
                }
            }

            // Ejecutar la inserción y verificar filas afectadas
            int filasAfectadas = stmtInsert.executeUpdate();
            System.out.println("Cantidad de inserciones realizadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                cantInsert++;
                System.out.println("Inserción exitosa para la fila.");
            } else {
                System.err.println("No se insertaron filas en esta iteración.");
            }
        }
    } catch (SQLException e) {
        System.err.println("Error ejecutando inserción: " + e.getMessage());
        e.printStackTrace();
    }

    // **Cuarta Parte: Retornar resultado final**
    System.out.println("Cantidad de inserciones realizadas: " + cantInsert);
    return cantInsert;
}




















}
