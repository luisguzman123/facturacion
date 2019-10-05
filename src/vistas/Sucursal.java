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
public class Sucursal {
    public void guardar(ventanas.Sucursal ventana){
        if(ventana.getNombre_suc_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar un nombre");
            ventana.getNombre_suc_txt().requestFocus();
            return;
                    
        }
         
        if(ventana.getDireccion_txt3().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar una direccion");
            ventana.getDireccion_txt3().requestFocus();
            return;
                    
        }
        new controlador.Sucursal().guardar(new modelos.Sucursal(
                ventana.getNombre_suc_txt().getText(),
                ventana.getDireccion_txt3().getText()));
                        
        JOptionPane.showMessageDialog(ventana, "Guardado Correctamente");
        
        ventana.getNombre_suc_txt().setText("");
        ventana.getDireccion_txt3().setText("");
        ventana.getNombre_suc_txt().requestFocus();
        
    }
    
    public void actualizar(ventanas.EditarSucursal ventana){
        if(ventana.getNombre_suc_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar un nombre");
            ventana.getNombre_suc_txt().requestFocus();
            return;
                    
        }
        if(ventana.getDireccion_txt3().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar una direccion");
            ventana.getDireccion_txt3().requestFocus();
            return;
                    
        }
        
        new controlador.Sucursal().actualizar(new modelos.Sucursal(
                ventana.getCodigo_sucursal(),  
                ventana.getNombre_suc_txt().getText(),
                ventana.getDireccion_txt3().getText()));
                
        
        JOptionPane.showMessageDialog(ventana, "Actualizado Correctamente");
        
        ventana.getNombre_suc_txt().setText("");
        ventana.getDireccion_txt3().setText("");
        ventana.getNombre_suc_txt().requestFocus();
        ventana.dispose();
        
    }
    
    public void buscarPorNombre(String nombre, JTable tabla){
        ArrayList<modelos.Sucursal> sucursales = new controlador.Sucursal().dameSucursalesPorNombre(nombre);
        
       
        new util.Tablas().limpiarTabla(tabla);
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        Object[] fila = new Object[3];
        for (modelos.Sucursal sucursal : sucursales) {
            fila[0] = sucursal.getId_sucursal();
            fila[1] = sucursal.getNombre();
            fila[2] = sucursal.getDireccion();
            modelo.addRow(fila);
        }
        tabla.setModel(modelo);
                
        
    }
    
    public void cargarTabla(JTable tabla){
        new util.Tablas().limpiarTabla(tabla);
        ArrayList<modelos.Sucursal> sucursales = new controlador.Sucursal().dameSucursales();
        Object[] fila = new Object[3];
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (modelos.Sucursal sucursal : sucursales) {
            fila[0] = sucursal.getId_sucursal();
            fila[1] = sucursal.getNombre();
            fila[2] = sucursal.getDireccion();
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
        new controlador.Sucursal().cambiarEstado(
                Integer.parseInt(
                        tabla.getValueAt(tabla.getSelectedRow(),
                                0).toString()), 0);
        
        new vistas.Sucursal().cargarTabla(tabla);
        JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
    }
    
    public void editarSucursal(ventanas.Sucursal ventana){
        if(ventana.getDatos_suc_tb().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(ventana, "Selecciona un registro");
            return;
        }
        
        int fila = ventana.getDatos_suc_tb().getSelectedRow();
        modelos.Sucursal sucursal = new modelos.Sucursal( 
                Integer.parseInt(ventana.getDatos_suc_tb().getValueAt(fila, 0).toString()), 
                ventana.getDatos_suc_tb().getValueAt(fila, 1).toString(), 
                ventana.getDatos_suc_tb().getValueAt(fila, 2).toString()); 
                        
        new ventanas.EditarSucursal(null, true, sucursal).setVisible(true);
    cargarTabla(ventana.getDatos_suc_tb());
    }
}
