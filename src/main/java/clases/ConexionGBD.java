/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class ConexionGBD {
     public java.sql.Connection openConnection(String user, String password) throws SQLException {
        OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//localhost:1521/xe"); // jdbc:oracle:thin@//[hostname]:[port]/[DB service name]
		ods.setUser(user);
		ods.setPassword(password);
		Connection conn = ods.getConnection();

        return conn;
    }

    public void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }
    
    
    
}
