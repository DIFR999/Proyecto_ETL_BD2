/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import clases.DTO.ConexionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ConexionesDisponible {
      // Método para verificar si las credenciales pertenecen a un usuario administrador
    public boolean verificarCredenciales(String usuario, String password) {
        try {
            // Lista de usuarios administradores válidos
            String[] usuariosAdministradores = {"SYS", "SYSTEM", "ADMINISTRADOR","DBA"};

            // Verificamos si el usuario está en la lista de administradores
            boolean esAdministrador = false;
            for (String admin : usuariosAdministradores) {
                if (usuario.equalsIgnoreCase(admin)) {
                    esAdministrador = true;
                    break;
                }
            }

            // Si el usuario no es un administrador, retornar false
            if (!esAdministrador) {
                return false;
            }

            // Si es administrador, intentamos hacer la conexión
            ConexionGBD conexion = new ConexionGBD();
            Connection conn = conexion.openConnection(usuario, password);

            // Si la conexión es exitosa, cerrarla y retornar true
            conexion.closeConnection(conn);
            return true;
        } catch (Exception e) {
            
            return false;
        }
    }

    
    public ArrayList<ConexionDTO> obtenerConexionesDisponibles(String Usuario, String password){
        try {
            ConexionGBD conexion = new ConexionGBD();
            Connection conn = conexion.openConnection(Usuario, password);

            PreparedStatement select = conn.prepareStatement("SELECT s.sid, s.serial#, s.username, s.osuser, s.machine, s.program FROM v$session s WHERE s.status = 'INACTIVE'");
			ResultSet rslt = select.executeQuery();

            ArrayList<ConexionDTO> conexionesDisponibles = new ArrayList<ConexionDTO>();

            while (rslt.next()) {
                ConexionDTO conexionDTO = new ConexionDTO();
                if (rslt.getString("username").equals("SYSTEM")) {
                    continue;
                }
                conexionDTO.setSid(rslt.getInt("sid"));
                conexionDTO.setSerial(rslt.getInt("serial#"));
                conexionDTO.setUsername(rslt.getString("username"));
                conexionDTO.setOsuser(rslt.getString("osuser"));
                conexionDTO.setMachine(rslt.getString("machine"));
                conexionDTO.setProgram(rslt.getString("program"));

                conexionesDisponibles.add(conexionDTO);
			}

            conexion.closeConnection(conn);

            return conexionesDisponibles;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
