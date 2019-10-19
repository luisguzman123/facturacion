/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impresiones;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author gozmi
 */
public class Banco {
    public void imprimirBanco() {
            //direccion del reporte
            String ruta = System.getProperty("user.dir") + "\\src\\reportes\\reporteBanco.jasper";
            //creamos un mapa para pasar parametros
            Map map = new HashMap();
            //informacion del reporte a imprimir
            JasperPrint jprint;
            //configuramos el Cuadro de dialogo
            JDialog reporte = new JDialog();
            reporte.setModal(true);
            reporte.setSize(1200, 700);
            reporte.setLocationRelativeTo(null);
            reporte.setTitle("Reporte de Bancos");
            
        try {
            
            jprint = JasperFillManager.fillReport(ruta, map,
                    new conexion.Postgre().getConexion());
            JRViewer jv = new JRViewer(jprint);
            reporte.getContentPane().add(jv);
            //preguntar si hay resultados
            if(jprint.getPages().size() == 0) return;
            reporte.setVisible(true);
        } catch (JRException ex) {
//            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
