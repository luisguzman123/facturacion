/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class codigoprecio {
   public void cargarTabla(JTable tabla1, String codigo_barra){
        ArrayList<modelos.Precio_Articulos> lista = new controlador.Precio_Articulos().damePrecioArticuloporCodigodebarra(codigo_barra);
        Object[] fila = new Object[6];
        new util.Tablas().limpiarTabla(tabla1);
        
        DefaultTableModel modelo = (DefaultTableModel) tabla1.getModel();
        
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = lista.get(i).getId_articulo();
            fila[1] = lista.get(i).getNombre();
            fila[2] = lista.get(i).getCantidad();
            fila[3] = lista.get(i).getMayorista();
            fila[4] = lista.get(i).getMinorista();
            fila[5] = lista.get(i).getCodigo_barra();
            
            
            modelo.addRow(fila);
            
        }
        
        tabla1.setModel(modelo);
    }  
}
