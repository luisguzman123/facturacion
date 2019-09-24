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
public class Tipo_Cliente {
    
     private Connection con = new conexion.Postgre().getConexion();

    public void guardar(modelos.Tipo_Cliente objeto) {

        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO tipos_clientes(\n"
                    + "	descripcion, activo)\n"
                    + "	VALUES (?, 1);");
            pst.setString(1, objeto.getDescripcion());


            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al guardar datos en la tabla Tipo de Clientes: "
                    + e.getMessage());
        }

    }

    public void actualizar(modelos.Tipo_Cliente objeto) {

        try {
            PreparedStatement pst = con.prepareStatement("UPDATE tipos_clientes\n"
                    + "	SET descripcion=?\n"
                    + "	WHERE id_tipo_cliente=?;");
            pst.setString(1, objeto.getDescripcion());
            pst.setInt(2, objeto.getId_tipo_cliente());

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar datos en la tabla Tipo de Clientes: "
                    + e.getMessage());
        }

    }

    public void cambiarEstado(int id, int estado) {

        try {
            PreparedStatement pst = con.prepareStatement(""
                    + "UPDATE tipos_clientes SET activo  = ? "
                    + "WHERE id_tipo_cliente = ?;");
            pst.setInt(1, estado);
            pst.setInt(2, id);

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar datos en la tabla Tipo de Clientes: "
                    + e.getMessage());
        }

    }

    public ArrayList<modelos.Tipo_Cliente> dameTipoClientes() {
        ArrayList<modelos.Tipo_Cliente> datos = new ArrayList<>();
        try {

            String sql = "SELECT descripcion \n"
                    + "	FROM tipos_clientes  WHERE activo = 1 "
                    + "ORDER BY id_tipo_cliente;";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                datos.add(new modelos.Tipo_Cliente(
                        rs.getInt("id_tipo_cliente"), 
                        rs.getString("descripcion").trim()));                      
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla Tipo de Clientes: " + ex);
        }

        return datos;
    }
    
    public ArrayList<modelos.Tipo_Cliente> dameTipoClientesPorNombre(String nombre) {
        ArrayList<modelos.Tipo_Cliente> datos = new ArrayList<>();
        try {

            String sql = "SELECT id_tipo_cliente, descripcion, activo\n"
                    + "	FROM tipos_clientes \n"
                    + "	WHERE UPPER(descripcion) LIKE '%" + nombre.toUpperCase() + "%' and activo = 1;";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                datos.add(new modelos.Tipo_Cliente(
                        rs.getInt("id_tipo_cliente"), 
                        rs.getString("descripcion").trim(),
                        rs.getInt("activo")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla Tipos de Clientes: " + ex);
        }

       return datos;
    }
}
