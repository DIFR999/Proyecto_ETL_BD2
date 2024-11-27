/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Principal;
import clases.ConexionGBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class Proyecto_ETL_BD2 {

    public static void main(String[] args) {
        ConexionGBD conexion = new ConexionGBD();
        Connection conn = null;

        try {
            // Probar la conexión con usuario y contraseña
            conn = conexion.openConnection("C##_USR_INMOBILIARIA", "1234");

            // Si llegamos aquí, la conexión fue exitosa
            System.out.println("Conexión exitosa a la base de datos!");

            // Ver las tablas directamente dentro del main
            Statement stmt = conn.createStatement();
            String query = "SELECT table_name FROM user_tables"; // Mostrar las tablas del usuario actual
            ResultSet rs = stmt.executeQuery(query);

            // Imprimir los nombres de las tablas
            System.out.println("Tablas en la base de datos:");
            while (rs.next()) {
                System.out.println(rs.getString("table_name"));
            }

            // Cerrar el ResultSet y el Statement
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            // En caso de error con la conexión o consulta
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Asegurarse de cerrar la conexión, si fue abierta correctamente
            if (conn != null) {
                try {
                    conexion.closeConnection(conn);
                    System.out.println("Conexión cerrada correctamente.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
}
