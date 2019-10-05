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
public class Banco {
    public void guardar(ventanas.Banco ventana){
        if(ventana.getNombre_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar un nombre");
            ventana.getNombre_txt().requestFocus();
            return;
                    
        }
               
        new controlador.Banco().guardar(new modelos.Banco(
                ventana.getNombre_txt().getText()));
        
        JOptionPane.showMessageDialog(ventana, "Guardado Correctamente");
        
        ventana.getNombre_txt().setText("");
        ventana.getNombre_txt().requestFocus();
        
    }
    
    public void actualizar(ventanas.EditarBanco ventana){
        if(ventana.getNombre_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debes ingresar un nombre");
            ventana.getNombre_txt().requestFocus();
            return;
                    
        }
        
        new controlador.Banco().actualizar(new modelos.Banco( 
                ventana.getCodigo_banco(),
                ventana.getNombre_txt().getText()));
        
        JOptionPane.showMessageDialog(ventana, "Actualizado Correctamente");
        
        ventana.getNombre_txt().setText("");
        ventana.getNombre_txt().requestFocus();
        ventana.dispose();
        
    }
    
     public void buscarPorNombre(String nombre, JTable tabla){
        ArrayList<modelos.Banco> bancos = new controlador.Banco().dameBancosPorNombre(nombre);
        
//        if(alumnos.isEmpty()) return;
        
        new util.Tablas().limpiarTabla(tabla);
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        Object[] fila = new Object[2];
        for (modelos.Banco banco : bancos) {
            fila[0] = banco.getId_banco();
            fila[1] = banco.getDescripcion();
            modelo.addRow(fila);
        }
        tabla.setModel(modelo);
                
        
    }
    
    public void cargarTabla(JTable tabla){
        new util.Tablas().limpiarTabla(tabla);
        ArrayList<modelos.Banco> bancos = new controlador.Banco().dameBancos();
        Object[] fila = new Object[2];
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (modelos.Banco banco : bancos) {
            fila[0] = banco.getId_banco();
            fila[1] = banco.getDescripcion();
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
//        int fila = tabla.getSelectedRow();
//        String valor = tabla.getValueAt(fila, 0).toString();
//        int codigo = Integer.parseInt(valor);
//        System.out.println(tabla.getValueAt(tabla.getSelectedRow(),
//                            0));
        
        if(JOptionPane.showConfirmDialog(
                null, //sobre que componente se abre
                "Estas seguro de eliminar el registro?", //mensaje
                "ADVERTENCIA", //titulo de la ventana
                JOptionPane.YES_NO_OPTION) // botones si y no
                ==  JOptionPane.NO_OPTION){
            return;
        }
        new controlador.Banco().cambiarEstado(
                Integer.parseInt(
                        tabla.getValueAt(tabla.getSelectedRow(),
                                0).toString()), 0);
        
        new vistas.Banco().cargarTabla(tabla);
        JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
    }
    
    public void editarBanco(ventanas.Banco ventana){
        if(ventana.getDatos_tb().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(ventana, "Selecciona un registro");
            return;
        }
        
        int fila = ventana.getDatos_tb().getSelectedRow();
        modelos.Banco banco = new modelos.Banco(
                Integer.parseInt(ventana.getDatos_tb().getValueAt(fila, 0).toString()), 
                ventana.getDatos_tb().getValueAt(fila, 1).toString()); 
        
        new ventanas.EditarBanco(null, true, banco).setVisible(true);
    cargarTabla(ventana.getDatos_tb());
    }
    
    public void cargarListaCursos(JComboBox lista){
        lista.removeAllItems();
        ArrayList<modelos.Banco> bancos = new controlador.Banco().dameBancos();
        lista.addItem("Selecciona un curso");
        for (modelos.Banco banco : bancos) {
            lista.addItem(banco.getDescripcion());
        }
    }
}
