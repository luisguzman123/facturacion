/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gozmi
 */
public class Usuario {
    
    private Connection con = new conexion.Postgre().getConexion();

    public void guardar(modelos.Usuario objeto) {

        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios(\n"
                    + "	nombre_apellido, usuario, pass, id_sucursal, activo)\n"
                    + "	VALUES (?, ?, ?, ?, 1);");
            pst.setString(1, objeto.getNombre_apellido());
            pst.setString(2, objeto.getUsuario());
            pst.setString(3, objeto.getPass());
            pst.setInt(4, objeto.getId_sucursal());


            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al guardar datos en la tabla Usuarios: "
                    + e.getMessage());
        }

    }

    public void actualizar(modelos.Usuario objeto) {

        try {
            PreparedStatement pst = con.prepareStatement("UPDATE usuarios\n"
                    + "	SET nombre_apellido=?, usuario=?, pass=?, id_sucursal=?\n"
                    + "	WHERE id_usuario=?;");
            pst.setString(1, objeto.getNombre_apellido());
            pst.setString(2, objeto.getUsuario());
            pst.setString(3, objeto.getPass());
            pst.setInt(4, objeto.getId_sucursal());
            pst.setInt(5, objeto.getId_usuario());

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar datos en la tabla Usuarios: "
                    + e.getMessage());
        }

    }

    public void cambiarEstado(int id, int estado) {

        try {
            PreparedStatement pst = con.prepareStatement(""
                    + "UPDATE usuarios SET activo  = ? "
                    + "WHERE id_usuario = ?;");
            pst.setInt(1, estado);
            pst.setInt(2, id);

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar datos en la tabla Usuarios: "
                    + e.getMessage());
        }

    }

    public ArrayList<modelos.Usuario> dameUsuarios() {
        ArrayList<modelos.Usuario> datos = new ArrayList<>();
        try {

            String sql = "SELECT id_usuarios, nombre_apellido, usuario, pass, id_sucursal\n"
                    + "	FROM usuarios  WHERE activo = 1 "
                    + "ORDER BY id_usuario;";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                datos.add(new modelos.Usuario(
                        rs.getInt("id_usuario"), 
                        rs.getString("nombre_apellido").trim(), 
                        rs.getString("usuario").trim(), 
                        rs.getString("pass").trim(),
                        rs.getInt("id_sucursal")));                         
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla Usuarios: " + ex);
        }

        return datos;
    }
 
    public ArrayList<modelos.Usuario> dameUsuariosPorNombre(String nombre) {
        ArrayList<modelos.Usuario> datos1 = new ArrayList<>();
        try {

            String sql = "SELECT id_usuarios, nombre_apellido, usuario, pass, id_sucursal\n"
                    + "	FROM usuarios \n"
                    + "	WHERE UPPER(usario) LIKE '%" + nombre.toUpperCase() + "%' and activo = 1;";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                datos1.add(new modelos.Usuario(
                        rs.getInt("id_usuarios"), 
                        rs.getString("nombre_apellido").trim(),
                        rs.getString("usuario").trim(),
                        rs.getString("pass").trim(),
                        rs.getInt("id_sucursal"), 
                        rs.getInt("activo")));                                                
                        }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla Usuarios: " + ex);
        }

       return datos1;
       
    }
}
