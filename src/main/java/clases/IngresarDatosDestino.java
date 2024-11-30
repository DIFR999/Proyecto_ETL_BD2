/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

   import java.sql.*;
import java.util.*;
public class IngresarDatosDestino {
 


     // Método para preparar una única consulta de inserción
    public String prepararInsercion(Connection connOrg, ArrayList<String> camposDestino,
            ArrayList<String> camposOrigen, String tableOrigen, String tableDestino, boolean fromTable) {
         // Depuración para Connection (Asegurarse de que no sea nulo)
    System.out.println("Conexión Origen: " + (connOrg != null ? "Conexión válida" : "Conexión nula"));
    
    // Depuración para ArrayList camposDestino
    System.out.println("Campos de destino: " + (camposDestino != null ? camposDestino.toString() : "Lista vacía o nula"));
    
    // Depuración para ArrayList camposOrigen
    System.out.println("Campos de origen: " + (camposOrigen != null ? camposOrigen.toString() : "Lista vacía o nula"));
    
    // Depuración para la tabla de origen
    System.out.println("Tabla de origen: " + (tableOrigen != null ? tableOrigen : "Tabla de origen nula"));
    
    // Depuración para la tabla de destino
    System.out.println("Tabla de destino: " + (tableDestino != null ? tableDestino : "Tabla de destino nula"));
    
    // Depuración para el valor booleano fromTable
    System.out.println("¿Origen es tabla? : " + (fromTable ? "Sí" : "No"));
        String consultaPreparada = null;
        ResultSet rsOrg = null;

        try {
            // Construir la parte de la consulta SQL para seleccionar los campos de origen
            StringBuilder camposConsulta = new StringBuilder();
            for (String campo : camposOrigen) {
                camposConsulta.append(campo).append(", ");
            }
            camposConsulta.delete(camposConsulta.length() - 2, camposConsulta.length()); // Eliminar la última coma y el espacio

            // Generar la consulta para obtener datos del origen (tabla o consulta)
            String sqlOrigen;
            if (fromTable) {
                // Si el origen es una tabla, usamos un SELECT directo
                sqlOrigen = "SELECT " + camposConsulta.toString() + " FROM " + tableOrigen;
            } else {
                // Si el origen es una consulta, utilizamos directamente la consulta SQL proporcionada
                sqlOrigen = tableOrigen; // Aquí se asume que `tableOrigen` contiene la consulta válida
            }

            // Ejecutar la consulta de origen para verificar si es válida
            PreparedStatement stmtOrg = connOrg.prepareStatement(sqlOrigen);
            rsOrg = stmtOrg.executeQuery();

            // Construir la consulta de inserción dinámica con la cláusula EXISTS
            StringBuilder condicionesExists = new StringBuilder();
            for (String campo : camposDestino) {
                condicionesExists.append(campo).append(" = ? AND ");
            }
            condicionesExists.delete(condicionesExists.length() - 5, condicionesExists.length()); // Eliminar " AND"

            consultaPreparada = "INSERT INTO " + tableDestino + " (" + String.join(", ", camposDestino) + ") " +
                                "SELECT " + String.join(", ", camposDestino) + " " +
                                "WHERE NOT EXISTS (SELECT 1 FROM " + tableDestino + " WHERE " + condicionesExists + ")";

        } catch (SQLException e) {
            System.out.println("Error en metodo  "+ e.getMessage());
        }
        
        

        // Devolver la consulta preparada
        return consultaPreparada;
    }

   public int ejecutarInsercion(Connection connDes, String consultaPreparada,
                             String tableOrigen, boolean fromTable) {

    int cantInsert = 0;

    try {
        // Preparar la consulta de origen
        String sqlOrigen;
        if (fromTable) {
            // Si es una tabla, armamos un SELECT
            sqlOrigen = "SELECT * FROM " + tableOrigen; // Se asume que seleccionas todas las columnas de la tabla
        } else {
            // Si es una consulta, usamos el valor de `tableOrigen` como la consulta completa
            sqlOrigen = tableOrigen;
        }

        // Ejecutar la consulta de origen para obtener los datos
        PreparedStatement stmtOrg = connDes.prepareStatement(sqlOrigen);
        ResultSet rsOrg = stmtOrg.executeQuery();

        // Preparar la consulta de inserción
        PreparedStatement stmtInsert = connDes.prepareStatement(consultaPreparada);

        // Iterar sobre los resultados de la consulta de origen
        while (rsOrg.next()) {
            // Asignar los valores de la fila del ResultSet a la consulta de inserción
            for (int i = 1; i <= rsOrg.getMetaData().getColumnCount(); i++) {
                stmtInsert.setObject(i, rsOrg.getObject(i));
            }

            // Ejecutar la inserción
            int filasAfectadas = stmtInsert.executeUpdate();
            if (filasAfectadas > 0) {
                cantInsert++;
            }
        }

        rsOrg.close();
        stmtOrg.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return cantInsert;
}

}
