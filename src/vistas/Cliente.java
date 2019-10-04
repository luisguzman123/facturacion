
package vistas;

import javax.swing.JOptionPane;

/**
 *
 * @author Jere
 */
public class Cliente {
    
    public void guardar (ventanas.Cliente ventana){
        
        if(ventana.getNombre_cl_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar un nombre");
            ventana.getNombre_cl_txt().requestFocus();
            return;
        }
        if(ventana.getApellido_cl_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar un apellido");
            ventana.getApellido_cl_txt().requestFocus();
            return;
        }
        if(ventana.getCedula_cl_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar un numero de cedula");
            ventana.getCedula_cl_txt().requestFocus();
            return;
        }
        if(ventana.getRuc_cl_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar el RUC");
            ventana.getRuc_cl_txt().requestFocus();
            return;
        }
        if(ventana.getTelefono_cl_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar un numero de telefono");
            ventana.getTelefono_cl_txt().requestFocus();
            return;
        }
        if(ventana.getDireccion_cl_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar una Direccion");
            ventana.getDireccion_cl_txt().requestFocus();
            return;
        }
        if(ventana.getCorreo_cl_txt().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar un correo");
            ventana.getCorreo_cl_txt().requestFocus();
            return;
        }
        new controlador.Cliente().guardar(new modelos.Cliente(
                ventana.getNombre_cl_txt().getText(), 
                ventana.getApellido_cl_txt().getText(), 
                ventana.getCedula_txt().getText(), 
                ventana.getRuc_cl_txt().getText(), 
                ventana.getTelefono_cl_txt().getText(), 
                ventana.getDireccion_cl_txt().getText(), 
                ventana.getCorreo_cl_txt().getText()));
        
        JOptionPane.showMessageDialog(ventana, "Guarado correctamente");
        
                ventana.getNombre_cl_txt().setText("");
                ventana.getApellido_cl_txt().setText("");
                ventana.getCedula_cl_txt().setText("");
                ventana.getRuc_cl_txt().setText("");
                ventana.getTelefono_cl_txt().setText("");
                ventana.getDireccion_cl_txt().setText("");
                ventana.getCorreo_cl_txt().setText("");
                
                ventana.getNombre_cl_txt().requestFocus();
    }
}
