/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI PRO6
 */
public class Lista {
    public boolean validarLista(JComboBox lista, String mensaje){
        if(lista.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, mensaje);
            lista.requestFocus();
            lista.setPopupVisible(true);
            return false;
        }
        return true;
    }
}
