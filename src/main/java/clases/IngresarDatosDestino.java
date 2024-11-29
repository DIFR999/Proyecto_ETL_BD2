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
            e.printStackTrace();
        }

        // Devolver la consulta preparada
        return consultaPreparada;
    }

    // Método para ejecutar la inserción preparada
    public int ejecutarInsercion(Connection connDes, String consultaPreparada,
            ArrayList<String> camposDestino, ArrayList<String> camposOrigen, ResultSet rsOrg) {

        int cantInsert = 0;

        try {
            // Preparar el statement para la consulta de inserción
            PreparedStatement stmtInsert = connDes.prepareStatement(consultaPreparada);

            // Iterar sobre los resultados de la consulta de origen
            while (rsOrg.next()) {
                // Asignar valores para la consulta SELECT
                for (int i = 0; i < camposDestino.size(); i++) {
                    stmtInsert.setObject(i + 1, rsOrg.getObject(camposOrigen.get(i)));
                }
                // Asignar valores para la cláusula EXISTS
                for (int i = 0; i < camposDestino.size(); i++) {
                    stmtInsert.setObject(camposDestino.size() + i + 1, rsOrg.getObject(camposOrigen.get(i)));
                }

                // Ejecutar la inserción
                int filasAfectadas = stmtInsert.executeUpdate();
                if (filasAfectadas > 0) {
                    cantInsert++;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cantInsert;
    }
}
