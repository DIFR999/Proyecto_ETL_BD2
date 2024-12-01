/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

   import java.sql.*;
import java.util.*;
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
                             String tableOrigen, boolean fromTable, ArrayList<String> camposOrigen) {
    // Mensajes de depuración para verificar los parámetros del método
    System.out.println("Depuración - Parámetros iniciales del método:");
    System.out.println("-------------------------------------------------");
    System.out.println("Conexión destino (connDes): " + (connDes != null ? "Conexión válida" : "Conexión nula"));
    System.out.println("Conexión origen (connOrg): " + (connOrg != null ? "Conexión válida" : "Conexión nula"));
    System.out.println("Consulta preparada: " + consultaPreparada);
    System.out.println("Tabla de origen: " + tableOrigen);
    System.out.println("Usar FROM en consulta: " + fromTable);
    System.out.println("Campos de origen: " + (camposOrigen != null ? String.join(", ", camposOrigen) : "Ninguno"));
    System.out.println("-------------------------------------------------");

    int cantInsert = 0;
    String ConsultaDesdeFROM = null;
    int indexFrom = tableOrigen.toUpperCase().indexOf("FROM");
    if (indexFrom != -1) {
        ConsultaDesdeFROM = tableOrigen.substring(indexFrom); // Retorna la parte de la consulta a partir de "FROM"
    }
    
    // Continuar con la lógica del método...
    try (PreparedStatement stmtOrg = connOrg.prepareStatement(
            fromTable ? "SELECT " + String.join(", ", camposOrigen) + " FROM " + tableOrigen 
                      : "SELECT " + String.join(", ", camposOrigen) + " " + ConsultaDesdeFROM);
         ResultSet rsOrg = stmtOrg.executeQuery();
         PreparedStatement stmtInsert = connDes.prepareStatement(consultaPreparada)) {

        // Lógica del método...

    } catch (SQLException e) {
        System.err.println("Error ejecutando inserción: " + e.getMessage());
        e.printStackTrace(); // Mostrar detalles completos del error
    }

    // Devolver la cantidad de inserciones realizadas
    System.out.println("Cantidad de inserciones realizadas: " + cantInsert);
    return cantInsert;
}












}
