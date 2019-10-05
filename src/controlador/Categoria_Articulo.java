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
public class Categoria_Articulo {
    
    private Connection con = new conexion.Postgre().getConexion();

    public void guardar(modelos.Categoria_Articulo objeto) {

        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO categorias(\n"
                    + "	descripcion, activo)\n"
                    + "	VALUES (?, 1);");
            pst.setString(1, objeto.getDescripcion());


            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al guardar datos en la tabla Categorías: "
                    + e.getMessage());
        }

    }

    public void actualizar(modelos.Categoria_Articulo objeto) {

        try {
            PreparedStatement pst = con.prepareStatement("UPDATE categorias\n"
                    + "	SET descripcion=?\n"
                    + "	WHERE id_categoria=?;");
            pst.setString(1, objeto.getDescripcion());
            pst.setInt(2, objeto.getId_categoria_articulo());

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar datos en la tabla Categorias: "
                    + e.getMessage());
        }

    }

    public void cambiarEstado(int id, int estado) {

        try {
            PreparedStatement pst = con.prepareStatement(""
                    + "UPDATE categorias SET activo  = ? "
                    + "WHERE id_categoria = ?;");
            pst.setInt(1, estado);
            pst.setInt(2, id);

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar datos en la tabla Categorias: "
                    + e.getMessage());
        }

    }

    public ArrayList<modelos.Categoria_Articulo> dameCategorias() {
        ArrayList<modelos.Categoria_Articulo> datos = new ArrayList<>();
        try {

            String sql = "SELECT id_categoria, descripcion \n"
                    + "	FROM categorias  WHERE activo = 1 "
                    + "ORDER BY id_categoria;";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                datos.add(new modelos.Categoria_Articulo( 
                        rs.getInt("id_categoria"), 
                        rs.getString("descripcion").trim()));
                                               
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla Categorías: " + ex);
        }

        return datos;
    }
    
    public ArrayList<modelos.Categoria_Articulo> dameCategoriasPorNombre(String nombre) {
        ArrayList<modelos.Categoria_Articulo> datos = new ArrayList<>();
        try {

            String sql = "SELECT id_categoria, descripcion, activo\n"
                    + "	FROM categorias \n"
                    + "	WHERE UPPER(descripcion) LIKE '%" + nombre.toUpperCase() + "%' and activo = 1;";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                datos.add(new modelos.Categoria_Articulo( 
                        rs.getInt("id_categoria"), 
                        rs.getString("descripcion").trim(),
                        rs.getInt("activo")));                                                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla Categorías: " + ex);
        }

       return datos;
    }

}
