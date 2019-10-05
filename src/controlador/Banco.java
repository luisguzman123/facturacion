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
public class Banco {
    
    private Connection con = new conexion.Postgre().getConexion();

    public void guardar(modelos.Banco objeto) {

        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO bancos(\n"
                    + "	descripcion, activo)\n"
                    + "	VALUES (?, 1);");
            pst.setString(1, objeto.getDescripcion());


            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al guardar datos en la tabla Bancos: "
                    + e.getMessage());
        }

    }

    public void actualizar(modelos.Banco objeto) {

        try {
            PreparedStatement pst = con.prepareStatement("UPDATE bancos\n"
                    + "	SET descripcion=?\n"
                    + "	WHERE id_banco=?");
            pst.setString(1, objeto.getDescripcion());
            pst.setInt(2, objeto.getId_banco());

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar datos en la tabla Bancos: "
                    + e.getMessage());
        }

    }

    public void cambiarEstado(int id, int estado) {

        try {
            PreparedStatement pst = con.prepareStatement(""
                    + "UPDATE bancos SET activo  = ? "
                    + "WHERE id_banco = ?;");
            pst.setInt(1, estado);
            pst.setInt(2, id);

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar datos en la tabla Bancos: "
                    + e.getMessage());
        }

    }

    public ArrayList<modelos.Banco> dameBancos() {
        ArrayList<modelos.Banco> datos = new ArrayList<>();
        try {

            String sql = "SELECT id_banco, descripcion \n"
                    + "	FROM bancos  WHERE activo = 1 "
                    + "ORDER BY id_banco";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                datos.add(new modelos.Banco( 
                        rs.getInt("id_banco"), 
                        rs.getString("descripcion").trim()));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla Bancos: " + ex);
        }

        return datos;
    }
    
    public ArrayList<modelos.Banco> dameBancosPorNombre(String nombre) {
        ArrayList<modelos.Banco> datos = new ArrayList<>();
        try {

            String sql = "SELECT id_banco, descripcion, activo\n"
                    + "	FROM bancos \n"
                    + "	WHERE UPPER(descripcion) LIKE '%" + nombre.toUpperCase() + "%' and activo = 1;";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                datos.add(new modelos.Banco( 
                        rs.getInt("id_banco"), 
                        rs.getString("descripcion").trim(),
                        rs.getInt("activo")));
                                                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla BANCOS: " + ex);
        }

       return datos;
    }

}
