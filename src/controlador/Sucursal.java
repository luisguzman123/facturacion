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
public class Sucursal {
    
    private Connection con = new conexion.Postgre().getConexion();

    public void guardar(modelos.Sucursal objeto) {

        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO sucursales(\n"
                    + "	nombre, direccion, activo)\n"
                    + "	VALUES (?, ?, 1);");
            pst.setString(1, objeto.getNombre());
            pst.setString(2, objeto.getDireccion());


            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al guardar datos en la tabla Sucursales: "
                    + e.getMessage());
        }

    }

    public void actualizar(modelos.Sucursal objeto) {

        try {
            PreparedStatement pst = con.prepareStatement("UPDATE sucursales\n"
                    + "	SET nombre=?, direccion=?\n"
                    + "	WHERE id_sucursal=?;");
            pst.setString(1, objeto.getNombre());
            pst.setString(2, objeto.getDireccion());
            pst.setInt(3, objeto.getId_sucursal());

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar datos en la tabla Sucursales: "
                    + e.getMessage());
        }

    }

    public void cambiarEstado(int id, int estado) {

        try {
            PreparedStatement pst = con.prepareStatement(""
                    + "UPDATE sucursales SET activo  = ? "
                    + "WHERE id_sucursal = ?;");
            pst.setInt(1, estado);
            pst.setInt(2, id);

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar datos en la tabla Sucursales: "
                    + e.getMessage());
        }

    }

    public ArrayList<modelos.Sucursal> dameSucursales() {
        ArrayList<modelos.Sucursal> datos1 = new ArrayList<>();
        try {

            String sql = "SELECT id_sucursal, nombre, direccion \n"
                    + "	FROM sucursales  WHERE activo = 1 "
                    + "ORDER BY id_sucursal";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                datos1.add(new modelos.Sucursal(
                        rs.getInt("id_sucursal"), 
                        rs.getString("nombre").trim(), 
                        rs.getString("direccion").trim()));                         
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla Sucursales: " + ex);
        }

        return datos1;
    }
    
    public ArrayList<modelos.Sucursal> dameSucursalesPorNombre(String nombre) {
        ArrayList<modelos.Sucursal> datos1 = new ArrayList<>();
        try {

            String sql = "SELECT id_sucursal, nombre, direccion, activo\n"
                    + "	FROM sucursales \n"
                    + "	WHERE UPPER(nombre) LIKE '%" + nombre.toUpperCase() + "%' and activo = 1;";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                datos1.add(new modelos.Sucursal(
                        rs.getInt("id_sucursal"), 
                        rs.getString("nombre").trim(),
                        rs.getString("direccion").trim(),
                        rs.getInt("activo")));                                                
                        }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla Sucursales: " + ex);
        }

       return datos1;
       
    }
    
    public modelos.Sucursal dameSucursalesPorNombre1(String nombre) {
        try {

            String sql = "SELECT id_sucursal, nombre, direccion, activo\n"
                    + "	FROM sucursales \n"
                    + "	WHERE UPPER(nombre) LIKE '%" + nombre.toUpperCase() + "%' and activo = 1;";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                return (new modelos.Sucursal(
                        rs.getInt("id_sucursal"), 
                        rs.getString("nombre").trim(),
                        rs.getString("direccion").trim(),
                        rs.getInt("activo")));                                                
                        }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla Sucursales: " + ex);
        }

      
       return new modelos.Sucursal();
    }
}
