/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gozmi
 */
public class Categoria_Articulo {
    
    public void guardar(ventanas.Categoria_Articulo ventana){
        if(ventana.getNombre_cat_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar una descripcion");
            ventana.getNombre_cat_txt().requestFocus();
            return;
                    
        }
               
        new controlador.Categoria_Articulo().guardar(new modelos.Categoria_Articulo(
                ventana.getNombre_cat_txt().getText()));
                
        
        JOptionPane.showMessageDialog(ventana, "Guardado Correctamente");
        
        ventana.getNombre_cat_txt().setText("");
        ventana.getNombre_cat_txt().requestFocus();
        
    }
    
    public void actualizar(ventanas.EditarCategoria_Articulo ventana){
        if(ventana.getNombre_cat_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar una descripcion");
            ventana.getNombre_cat_txt().requestFocus();
            return;
                    
        }
        
        new controlador.Categoria_Articulo().actualizar(new modelos.Categoria_Articulo(
                ventana.getCodigo_categoria(),  
                ventana.getNombre_cat_txt().getText()));
        
        JOptionPane.showMessageDialog(ventana, "Actualizado Correctamente");
        
        ventana.getNombre_cat_txt().setText("");
        ventana.getNombre_cat_txt().requestFocus();
        ventana.dispose();
        
    }
    
    public void buscarPorNombre(String nombre, JTable tabla){
        ArrayList<modelos.Categoria_Articulo> categorias = new controlador.Categoria_Articulo().dameCategoriasPorNombre(nombre);
        
       
        new util.Tablas().limpiarTabla(tabla);
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        Object[] fila = new Object[2];
        for (modelos.Categoria_Articulo categoria : categorias) {
            fila[0] = categoria.getId_categoria_articulo();
            fila[1] = categoria.getDescripcion();
            modelo.addRow(fila);
        }
        tabla.setModel(modelo);
                
        
    }
    
    public void cargarTabla(JTable tabla){
        new util.Tablas().limpiarTabla(tabla);
        ArrayList<modelos.Categoria_Articulo> categorias = new controlador.Categoria_Articulo().dameCategorias();
        Object[] fila = new Object[2];
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (modelos.Categoria_Articulo categoria : categorias) {
            fila[0] = categoria.getId_categoria_articulo();
            fila[1] = categoria.getDescripcion();
            modelo.addRow(fila);
        }
        
        tabla.setModel(modelo);
        
    }
    
    public void borrarFila(JTable tabla){
        if(tabla.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "No hay registros");
            return;
        }
        
        if(tabla.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Debes seleccionar un registro");
            return;
        }
        
        if(JOptionPane.showConfirmDialog(
                null,
                "Estas seguro de eliminar el registro?", 
                "ADVERTENCIA", 
                JOptionPane.YES_NO_OPTION) 
                ==  JOptionPane.NO_OPTION){
            return;
        }
        new controlador.Categoria_Articulo().cambiarEstado(
                Integer.parseInt(
                        tabla.getValueAt(tabla.getSelectedRow(),
                                0).toString()), 0);
        
        new vistas.Categoria_Articulo().cargarTabla(tabla);
        JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
    }
    
    public void editarCategoria_Art(ventanas.Categoria_Articulo ventana){
        if(ventana.getDatos_tb().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(ventana, "Selecciona un registro");
            return;
        }
        
        int fila = ventana.getDatos_tb().getSelectedRow();
        modelos.Categoria_Articulo categoria = new modelos.Categoria_Articulo( 
                Integer.parseInt(ventana.getDatos_tb().getValueAt(fila, 0).toString()), 
                ventana.getDatos_tb().getValueAt(fila, 1).toString()); 
        
        new ventanas.EditarCategoria_Articulo(null, true, categoria).setVisible(true);
    cargarTabla(ventana.getDatos_tb());
    }
  public void cargarListaCategoria(JComboBox lista) {
        lista.removeAllItems();
        ArrayList<modelos.Categoria_Articulo> categorias = new controlador.Categoria_Articulo().dameCategorias();
        lista.addItem("Selecciona una Categoria");
        for (int i = 0; i < categorias.size(); i++) {

            lista.addItem(categorias.get(i).getDescripcion());

        }

    }
    
    
    
    
    
    
}
