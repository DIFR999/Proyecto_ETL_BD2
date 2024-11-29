/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import clases.DTO.CampoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CamposPorTablaConsulta {
   public ArrayList<CampoDTO> obtenerCampos(Connection conn2, String table) {
    ArrayList<CampoDTO> campos = new ArrayList<>();

    String query = """
            SELECT column_name, data_type, data_length 
            FROM user_tab_columns 
            WHERE table_name = ?
            ORDER BY column_id
            """;

    try (PreparedStatement select = conn2.prepareStatement(query)) {
        // Convertir el nombre de la tabla a mayúsculas
        select.setString(1, table.toUpperCase());

        try (ResultSet rslt = select.executeQuery()) {
            while (rslt.next()) {
                CampoDTO campoDTO = new CampoDTO();

                // Asignar valores del ResultSet al objeto CampoDTO
                campoDTO.setColumnName(rslt.getString("column_name"));
                campoDTO.setColumnNameConvert(rslt.getString("column_name"));
                campoDTO.setAlias(rslt.getString("column_name"));
                campoDTO.setDataType(rslt.getString("data_type"));

                // Verificar si el tipo de dato es VARCHAR2 y asignar longitud
                if ("VARCHAR2".equalsIgnoreCase(rslt.getString("data_type"))) {
                    campoDTO.setMaxLength(rslt.getInt("data_length"));
                    campoDTO.setMaxLeghtConvert(rslt.getInt("data_length"));
                }

                // Agregar el objeto a la lista
                campos.add(campoDTO);
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener campos: " + e.getMessage());
        e.printStackTrace();
    }

    return campos;
}


    //SI SE SELECCIONA UNA CONSULTA
    public ArrayList<CampoDTO> obtenerCamposConsulta(Connection conn2, String consulta) throws SQLException {
       
        ArrayList<CampoDTO> campos = new ArrayList<>();
        
        // Validar que la consulta sea una sentencia SELECT
    if (!consulta.trim().toUpperCase().startsWith("SELECT")) {
        throw new SQLException("Solo se permiten consultas SELECT.");
    }

    // Preparar la consulta y obtener el resultado
    try (PreparedStatement select = conn2.prepareStatement(consulta);
         ResultSet rslt = select.executeQuery()) {

        // Obtener metadatos de las columnas del resultado
        ResultSetMetaData metaData = rslt.getMetaData();
        int columnCount = metaData.getColumnCount(); // Número total de columnas en el resultado

        // Construir la lista de objetos CampoDTO a partir de los metadatos
        for (int i = 1; i <= columnCount; i++) {
            CampoDTO campoDTO = new CampoDTO(); // Crear un objeto CampoDTO para cada columna
            campoDTO.setColumnName(metaData.getColumnName(i)); // Nombre de la columna
            campoDTO.setDataType(metaData.getColumnTypeName(i)); // Tipo de dato de la columna
            campoDTO.setColumnNameConvert(metaData.getColumnName(i)); // Nombre convertido (puedes personalizar)
            campoDTO.setAlias(metaData.getColumnName(i)); // Alias (puedes usar el mismo nombre si no hay alias)

            // Verificar si el tipo de dato es VARCHAR para obtener la longitud máxima
            if ("VARCHAR2".equalsIgnoreCase(metaData.getColumnTypeName(i)) || 
                "VARCHAR".equalsIgnoreCase(metaData.getColumnTypeName(i))) {
                int maxLength = metaData.getColumnDisplaySize(i); // Longitud máxima del dato
                campoDTO.setMaxLength(maxLength); // Establecer longitud en CampoDTO
                campoDTO.setMaxLeghtConvert(maxLength); // Establecer longitud convertida
            }

            // Agregar el objeto CampoDTO a la lista
            campos.add(campoDTO);
        }
    }

    // Retornar la lista de objetos CampoDTO
    return campos;
    }
    
  
}
