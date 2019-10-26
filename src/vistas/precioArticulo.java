/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.Precio_Articulos;

/**
 *
 * @author Msi Pro 3
 */
public class precioArticulo {
    
 public void cargarTabla(JTable tabla, String nombre){
        ArrayList<modelos.Precio_Articulos> lista = new controlador.Precio_Articulos().damePrecioArticuloporNombre(nombre);
        Object[] fila = new Object[5];
        new util.Tablas().limpiarTabla(tabla);
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = lista.get(i).getId_articulo();
            fila[1] = lista.get(i).getNombre();
            fila[2] = lista.get(i).getCantidad();
            fila[3] = lista.get(i).getMayorista();
            fila[4] = lista.get(i).getMinorista();
            
            modelo.addRow(fila);
            
        }
        
        tabla.setModel(modelo);
    }
}