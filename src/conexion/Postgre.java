/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI PRO6
 */
public class Postgre {
    private static Connection conexion;

    public void crearConexion() {
        conexion =  this.conexion();
    }

    public  Connection getConexion() {
        return conexion;
    }
    
    
    
    public Connection conexion(){
        String base_datos = "jdbc:postgresql://localhost:5432/sistema";
        String usuario = "postgres";
        String pass = "123";
        Connection con =  null;
        try {
            
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(base_datos, usuario, pass);
            System.out.println("conectado");
        } catch (ClassNotFoundException ex) {
            System.out.println(
                    "Error en obtencion de driver: "+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error en conexion: "+ex.getMessage());
        }
        return con;
    }
}
