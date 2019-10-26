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
public class Precio_Articulos {
      private Connection con = new conexion.Postgre().getConexion();

    public void guardar(modelos.Precio_Articulos objeto) {

        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO public.comercial(\n"
                    + "	Precio_articulo, sucursal, articulo,mayorista,minorista, activo)\n"
                    + "	VALUES (?, ?, ?, ?,?);");
            pst.setInt(1, objeto.getPrecio_articulo());
            pst.setInt(2, objeto.getSucursal());
            pst.setInt(3, objeto.getArticulo());
            pst.setInt(4, objeto.getMinorista());
            pst.setInt(5, objeto.getMayorista());
            

            pst.executeUpdate();

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al guardar datos en la tabla cursos: "
                    + e.getMessage());
        }
    }
    public ArrayList<modelos.Precio_Articulos> damePrecioArticulo(int articulo) {
        ArrayList<modelos.Precio_Articulos> datos = new ArrayList<>();
        try {

            String sql = "SELECT Precio_Articulo, sucursal, articulo,mayorista,minorista, activo\n"
                    + "	FROM articulo \n"
                    + "	WHERE UPPER(mayorista||' '||minorista) LIKE '%" + articulo + "%' and activo = 1;";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                datos.add(new modelos.Precio_Articulos(
                        rs.getInt("Precio_Articulo"),
                        rs.getInt("sucursal"),
                        rs.getInt("articulo"),
                        rs.getInt("mayorista"),
                        rs.getInt("minorista"),
                        rs.getString("nombre"),
                        rs.getInt("cantidad")
                        
                        ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla Precio Articulo: " + ex);
        }

        return datos;
    }
     public ArrayList<modelos.Precio_Articulos> damePrecioArticuloporNombre(String Nombre) {
        ArrayList<modelos.Precio_Articulos> datos = new ArrayList<>();
        try {

            String sql = "SELECT \n" +
"ar.id_articulo,\n" +
"ar.nombre,\n" +
"sa.cantidad,\n" +
"pa.precio_mayorista,\n" +
"pa.precio_minorista\n" +
"FROM articulos ar\n" +
"JOIN precios_articulos pa\n" +
"ON pa.id_articulo = ar.id_articulo\n" +
"JOIN stock_articulos sa\n" +
"ON sa.id_articulo = ar.id_articulo\n" +
"WHERE ar.nombre ilike'%"+Nombre+"%';";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                datos.add(new modelos.Precio_Articulos(rs.getInt("id_articulo"),
                        rs.getInt("Precio_minorista"), 
                        rs.getInt("Precio_mayorista"),
                        rs.getString("nombre"),
                        rs.getInt("cantidad")));
                        
                    
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla Precio Articulo: " + ex);
        }

        return datos;
    }
  
   public ArrayList<modelos.Precio_Articulos> damePrecioArticuloporCodigodebarra(String cod) {
        ArrayList<modelos.Precio_Articulos> datos = new ArrayList<>();
        try {

            String sql = "SELECT  \n" +
"ar.id_articulo,\n" +
"ar.codigo_barra,\n" +
"ar.nombre, \n" +
"sa.cantidad,\n" +
"pa.precio_mayorista,\n" +
"pa.precio_minorista\n" +
"FROM articulos ar\n" +
"JOIN precios_articulos pa\n" +
"ON pa.id_articulo = ar.id_articulo\n" +
"JOIN stock_articulos sa\n" +
"ON sa.id_articulo = ar.id_articulo\n" +
"WHERE ar.codigo_barra ilike '"+cod+"'";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                datos.add(new modelos.Precio_Articulos(rs.getInt("id_articulo"),
                        rs.getInt("Precio_minorista"), 
                        rs.getInt("Precio_mayorista"),
                        rs.getString("nombre"),
                        rs.getInt("cantidad"),
                        rs.getString("codigo_barra")));
                        
                    
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla Precio Articulo: " + ex);
        }

        return datos;
    }      
    
}
