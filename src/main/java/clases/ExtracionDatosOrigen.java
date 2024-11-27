/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ExtracionDatosOrigen {
     public ArrayList<String> obtenerTablas(String userDB, Connection conn2){
        try {
            
            PreparedStatement select = conn2.prepareStatement("SELECT table_name FROM all_tables WHERE owner = '" + userDB + "'");
			ResultSet rslt = select.executeQuery();

            ArrayList<String> tablas = new ArrayList<String>();

            while (rslt.next()) {
                tablas.add(rslt.getString("table_name"));
			}


            return tablas;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
