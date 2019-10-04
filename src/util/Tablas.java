/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI PRO6
 */
public class Tablas {
    public void limpiarTabla(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int fila = tabla.getRowCount();
        
        for (int i = 1; i <= fila; i++) {
            modelo.removeRow(0);
        }
        tabla.setModel(modelo);
    }
    
}
