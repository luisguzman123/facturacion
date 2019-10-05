/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gozmi
 */
public class Tipo_Cliente {
    
     
    public void guardar(ventanas.Tipo_Cliente ventana){
        if(ventana.getNombre_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar una descripcion");
            ventana.getNombre_txt().requestFocus();
            return;
                    
        }
               
        new controlador.Tipo_Cliente().guardar(new modelos.Tipo_Cliente(
                ventana.getNombre_txt().getText()));
        
        JOptionPane.showMessageDialog(ventana, "Guardado Correctamente");
        
        ventana.getNombre_txt().setText("");
        ventana.getNombre_txt().requestFocus();
        
    }
    
    public void actualizar(ventanas.EditarTipo_Cliente ventana){
        if(ventana.getNombre_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar una descripcion");
            ventana.getNombre_txt().requestFocus();
            return;
                    
        }
        
        new controlador.Tipo_Cliente().actualizar(new modelos.Tipo_Cliente(
                ventana.getCodigo_tipo_cl(), 
                ventana.getNombre_txt().getText()));
               
        JOptionPane.showMessageDialog(ventana, "Actualizado Correctamente");
        
        ventana.getNombre_txt().setText("");
        ventana.getNombre_txt().requestFocus();
        ventana.dispose();
        
    }
    
    public void buscarPorNombre(String nombre, JTable tabla){
        ArrayList<modelos.Tipo_Cliente> tipos = new controlador.Tipo_Cliente().dameTipoClientesPorNombre(nombre);
             
        new util.Tablas().limpiarTabla(tabla);
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        Object[] fila = new Object[2];
        for (modelos.Tipo_Cliente tipo : tipos) {
            fila[0] = tipo.getId_tipo_cliente();
            fila[1] = tipo.getDescripcion();
            modelo.addRow(fila);
        }
        tabla.setModel(modelo);
                
        
    }
    
    public void cargarTabla(JTable tabla){
        new util.Tablas().limpiarTabla(tabla);
        ArrayList<modelos.Tipo_Cliente> tipos = new controlador.Tipo_Cliente().dameTipoClientes();
        Object[] fila = new Object[2];
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (modelos.Tipo_Cliente tipo : tipos) {
            fila[0] = tipo.getId_tipo_cliente();
            fila[1] = tipo.getDescripcion();
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
        new controlador.Tipo_Cliente().cambiarEstado(
                Integer.parseInt(
                        tabla.getValueAt(tabla.getSelectedRow(),
                                0).toString()), 0);
        
        new vistas.Tipo_Cliente().cargarTabla(tabla);
        JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
    }
    
    public void editarTipo_Cliente(ventanas.Tipo_Cliente ventana){
        if(ventana.getDatos_tb().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(ventana, "Selecciona un registro");
            return;
        }
        
        int fila = ventana.getDatos_tb().getSelectedRow();
        modelos.Banco banco = new modelos.Banco(
                Integer.parseInt(ventana.getDatos_tb().getValueAt(fila, 0).toString()), 
                ventana.getDatos_tb().getValueAt(fila, 1).toString()); 
        
        new ventanas.EditarTipo_Cliente(null, true, banco).setVisible(true);
    cargarTabla(ventana.getDatos_tb());
    }
    
}
