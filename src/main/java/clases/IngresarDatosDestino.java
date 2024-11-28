/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

   import java.sql.*;
import java.util.*;
public class IngresarDatosDestino {
 


    // Método para preparar las inserciones sin ejecutarlas inmediatamente
    public List<String> prepararInserciones(Connection connOrg, Connection connDes,
            ArrayList<String> camposDestino, ArrayList<String> camposOrigen, String tableOrigen, 
            String tableDestino, boolean fromTable) {
        
        List<String> consultasPreparadas = new ArrayList<>();
        ResultSet rsOrg = null;

        try {
            // Construir la parte de la consulta SQL para seleccionar los campos de origen
            StringBuilder camposConsulta = new StringBuilder();
            for (String campo : camposOrigen) {
                camposConsulta.append(campo).append(", ");
            }
            camposConsulta.delete(camposConsulta.length() - 2, camposConsulta.length()); // Eliminar la última coma y el espacio

            // Verificamos si 'tableOrigen' es una tabla o una consulta SQL
            if (fromTable) {
                // Si es una tabla, usamos un SELECT directo
                String sql = "SELECT " + camposConsulta.toString() + " FROM " + tableOrigen;
                PreparedStatement stmtOrg = connOrg.prepareStatement(sql);
                rsOrg = stmtOrg.executeQuery();
            } else {
                // Si es una consulta, ejecutamos directamente la consulta SQL
                PreparedStatement stmtOrg = connOrg.prepareStatement(tableOrigen);
                rsOrg = stmtOrg.executeQuery();
            }

            // Obtener la metadata del ResultSet para conocer las columnas
            ResultSetMetaData metaData = rsOrg.getMetaData();
            int cantidadColumnas = metaData.getColumnCount();

            // Preparar la consulta de inserción para la tabla de destino con la cláusula EXISTS
            StringBuilder consultaInsert = new StringBuilder("INSERT INTO " + tableDestino + " (" 
                    + String.join(", ", camposDestino) + ") ");
            consultaInsert.append("SELECT ?, ?, ? WHERE NOT EXISTS (SELECT 1 FROM " + tableDestino + " WHERE id = ?)");

            // Almacenar la consulta preparada para su ejecución posterior
            consultasPreparadas.add(consultaInsert.toString());

            // Se pueden construir y almacenar múltiples consultas si es necesario para otras tablas
            // Repetir el mismo proceso para otras tablas (no mostrado aquí).

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolver las consultas preparadas para que se ejecuten después
        return consultasPreparadas;
    }

    // Método para ejecutar las inserciones previamente preparadas
    public int ejecutarInserciones(Connection connDes, List<String> consultasPreparadas,
            ArrayList<String> camposDestino, ArrayList<String> camposOrigen, ResultSet rsOrg) {
        
        int cantInsert = 0;

        try {
            // Iterar sobre las consultas preparadas
            for (String consulta : consultasPreparadas) {
                PreparedStatement stmtInsert = connDes.prepareStatement(consulta);

                // Iterar sobre los resultados de la consulta de origen
                while (rsOrg.next()) {
                    // Asumimos que el primer campo de los datos es el ID
                    Object id = rsOrg.getObject(camposOrigen.get(0)); // Usamos el primer campo como ID

                    // Si el registro no existe en la tabla de destino, lo insertamos
                    for (int i = 0; i < camposDestino.size(); i++) {
                        stmtInsert.setObject(i + 1, rsOrg.getObject(camposOrigen.get(i)));
                    }
                    stmtInsert.setObject(camposDestino.size() + 1, id);  // ID para la cláusula EXISTS

                    // Ejecutar la inserción
                    int filasAfectadas = stmtInsert.executeUpdate();
                    if (filasAfectadas > 0) {
                        cantInsert++;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cantInsert;
    }
}
