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
public class Usuario {
    public void guardar(ventanas.Usuario ventana){
        if(ventana.getNombre_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar un nombre");
            ventana.getNombre_txt().requestFocus();
            return;
                    
        }
        if(ventana.getUsuario_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar un usuario");
            ventana.getUsuario_txt().requestFocus();
            return;
                    
        }
        if(ventana.getPass_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar una contraseña");
            ventana.getPass_txt().requestFocus();
            return;
                    
        }
        if(ventana.getSucursal_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes seleccionar una sucursal");
            ventana.getPass_txt().requestFocus();
            return;
                    
        }
        new controlador.Usuario().guardar(new modelos.Usuario(
                ventana.getNombre_txt().getText(),
                ventana.getUsuario_txt().getText(),
                ventana.getPass_txt().getText(),
                Integer.parseInt(ventana.getCodigo_sucursal().getText()))); 
                        
        JOptionPane.showMessageDialog(ventana, "Guardado Correctamente");
        
        ventana.getNombre_txt().setText("");
        ventana.getUsuario_txt().setText("");
        ventana.getPass_txt().setText("");
        ventana.getSucursal_txt().setText("");
        ventana.getNombre_txt().requestFocus();
        
    }
    
    public void actualizar(ventanas.EditarUsuario ventana){
        if(ventana.getNombre_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar un nombre");
            ventana.getNombre_txt().requestFocus();
            return;
                    
        }
        if(ventana.getUsuario_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar un usuario");
            ventana.getUsuario_txt().requestFocus();
            return;
                    
        }
        if(ventana.getPass_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar una contraseña");
            ventana.getPass_txt().requestFocus();
            return;
                    
        }
        if(ventana.getSucursal_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes seleccionar una sucursal");
            ventana.getPass_txt().requestFocus();
            return;
                    
        }
        new controlador.Usuario().actualizar(new modelos.Usuario(
                ventana.getCodigo_usuario(),  
                ventana.getNombre_txt().getText(),
                ventana.getUsuario_txt().getText(),
                ventana.getPass_txt().getText(),
                Integer.parseInt(ventana.getCodigo_sucursal().getText())));  
    
        
        JOptionPane.showMessageDialog(ventana, "Actualizado Correctamente");
        
        ventana.getNombre_txt().setText("");
        ventana.getUsuario_txt().setText("");
        ventana.getPass_txt().setText("");
        ventana.getSucursal_txt().setText("");
        ventana.getNombre_txt().requestFocus();
        ventana.dispose();
        
    }
    
    public void buscarPorNombre(String nombre, JTable tabla){
        ArrayList<modelos.Usuario> usuarios = new controlador.Usuario().dameUsuariosPorNombre(nombre);
        
       
        new util.Tablas().limpiarTabla(tabla);
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        Object[] fila = new Object[5];
        for (modelos.Usuario usuario : usuarios) {
            fila[0] = usuario.getId_usuario();
            fila[1] = usuario.getNombre_apellido();
            fila[2] = usuario.getUsuario();
            fila[3] = usuario.getPass();
            fila[4] = usuario.getId_sucursal();
            modelo.addRow(fila);
        }
        tabla.setModel(modelo);
                
        
    }
    
    public void cargarTabla(JTable tabla){
        new util.Tablas().limpiarTabla(tabla);
        ArrayList<modelos.Usuario> usuarios = new controlador.Usuario().dameUsuarios();
        Object[] fila = new Object[5];
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (modelos.Usuario usuario : usuarios) {
            fila[0] = usuario.getId_usuario();
            fila[1] = usuario.getNombre_apellido();
            fila[2] = usuario.getUsuario();
            fila[3] = usuario.getPass();
            fila[4] = usuario.getId_sucursal();
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
        new controlador.Usuario().cambiarEstado(
                Integer.parseInt(
                        tabla.getValueAt(tabla.getSelectedRow(),
                                0).toString()), 0);
        
        new vistas.Usuario().cargarTabla(tabla);
        JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
    }
    
    public void editarUsuario(ventanas.Usuario ventana){
        if(ventana.getDatos_tb().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(ventana, "Selecciona un registro");
            return;
        }
        
        int fila = ventana.getDatos_tb().getSelectedRow();
        modelos.Usuario usuario = new modelos.Usuario(
                Integer.parseInt(ventana.getDatos_tb().getValueAt(fila, 0).toString()),  
                ventana.getDatos_tb().getValueAt(fila, 1).toString(), 
                ventana.getDatos_tb().getValueAt(fila, 2).toString(), 
                ventana.getDatos_tb().getValueAt(fila, 3).toString(), 
                Integer.parseInt(ventana.getDatos_tb().getValueAt(fila, 4).toString()));
                
        
                        
        new ventanas.EditarUsuario(null, true, usuario).setVisible(true);
       
        cargarTabla(ventana.getDatos_tb());
    
    }
}
