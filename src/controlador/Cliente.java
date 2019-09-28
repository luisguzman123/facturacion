/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jere
 */
public class Cliente {
    private Connection con = new conexion.Postgre().getConexion();
    
    public void guardar(modelos.Cliente objeto){
        
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO clientes(\n" +
            "nombre, apellido, cedula, ruc, telefono, direccion, correo, activo)\n" +
            "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);");
       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar datos en"
                    + " la tabla de clientes"+e.getMessage());
        }
    
    }
     public void actualizar(modelos.Cliente objeto){
         
         try {
             PreparedStatement pst =con.prepareStatement("UPDATE clientes\n" +
             "SET nombre=?, apellido=?, cedula=?, ruc=?, telefono=?, direccion=?, correo=?\n" +
             "WHERE id_cliente=?;");
             
             pst.setString(1, objeto.getNombre());
             pst.setString(2, objeto.getApellido());
             pst.setString(3, objeto.getCedula());
             pst.setString(4, objeto.getRuc());
             pst.setString(5, objeto.getTelefono());
             pst.setString(6, objeto.getDireccion());
             pst.setString(7, objeto.getCorreo());
             pst.setInt(8, objeto.getId_cliente());
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error al gactualizar datos en"
                    + " la tabla de clientes"+e.getMessage());
         }
     }   
    
     public void cambiarEstado(int id,int estado){
         try {
            PreparedStatement pst = con.prepareStatement(""
                    + "UPDATE clientes SET activo  = ? "
                    + "WHERE id_cliente = ?;");
            pst.setInt(1, estado);
            pst.setInt(2, id);
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar datos en la tabla Clientes: "
                    + e.getMessage());
        }
         
     }
     public ArrayList<modelos.Cliente> dameClientes(){
         ArrayList<modelos.Cliente> datos = new ArrayList<>();
         
         try {
             
             String sql="SELECT id_cliente, nombre, apellido, cedula, ruc, "
              + "telefono, direccion, correo, id_tipo_cliente\n" +
                "FROM clientes WHERE activo= 1\n" +
                "ORDER BY id_cliente;";  
             
             Statement pst = con.createStatement();
             ResultSet rs = pst.executeQuery(sql);
             
             while(rs.next()){
                 datos.add(new modelos.Cliente(
                         rs.getInt("id_cliente"), 
                         rs.getString("nombre"), 
                         rs.getString("apellido"), 
                         rs.getString("cedula"), 
                         rs.getString("ruc"), 
                         rs.getString("telefono"), 
                         rs.getString("direccion"), 
                         rs.getString("correo"), 
                         rs.getInt("activo")));
             }
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error al leer la tabla");
         }
        
         return datos;
     } 
     
     
}
