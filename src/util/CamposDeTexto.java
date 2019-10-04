/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author MSI PRO6
 */
public class CamposDeTexto {
    /**
     * Esta funcion permite limpiar un campo de texto
     * <ul>
     * <li>Primer paso</li>
     * <li>Segundo paso</li>
     * <li>Terver paso</li>
     * </ul>
     * @param campo
     * @return 
     */
    public boolean limpiarCampo(JTextField campo){
        //code
        return true;
    }
    
    
    
    
    public boolean validarCampo(JTextField campo, 
            String mensaje){
        if(campo.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, mensaje);
            campo.requestFocus();
            return false;
        }
        return true;
    }
}
