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
 * @author Alejandro
 */
public class Stock_Articulos {
     private Connection con = new conexion.Postgre().getConexion();

    public void guardar(modelos.Stock_Articulos objeto) {

        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO public.comercial(\n"
                    + "	Stock_articulo, sucursal, articulo,cantidad, activo)\n"
                    + "	VALUES (?, ?, ?, ?,);");
            pst.setInt(1, objeto.getStock_articulo());
            pst.setInt(2, objeto.getSucursal());
            pst.setInt(3, objeto.getArticulo());
            pst.setInt(4, objeto.getCantidad());
            

            pst.executeUpdate();

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al guardar datos en la tabla stock Articulos: "
                    + e.getMessage());
        }
    }
     public ArrayList<modelos.Stock_Articulos> damestockArticulos() {
        ArrayList<modelos.Stock_Articulos> datos = new ArrayList<>();
        try {

            String sql = "SELECT Stock_articulo, sucursal, articulo,cantidad, activo\n"
                    + "	FROM cursos  WHERE activo = 1 "
                    + "ORDER BY Stock_articulo;";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                datos.add(new modelos.Stock_Articulos(
                        rs.getInt("stock_articulo"),
                        rs.getInt("sucursal"),
                        rs.getInt("cantidad"),
                        rs.getInt("activo")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla Stock Articulo: " + ex);
        }

        return datos;
    }
}
