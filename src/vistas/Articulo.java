/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Msi Pro 3
 */
public class Articulo {

    public void guardar(ventanas.GuardarArticulo ventana) {
        if (ventana.getNombretxt().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(ventana,
                    "Debes ingresar el Nombre");

        }
        if (ventana.getStocktxt().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(ventana,
                    "Debes ingresar el Stock");

            ventana.getNombretxt().requestFocus();
            return;
        }
        if (ventana.getCategoriaComboBox().getSelectedIndex() == 0) {

        }

    
    }
}
