/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author gozmi
 */
public class Tipo_Tarjeta {
    
    private int id_tipo_tarjeta;
    private String descripcion;
    private int activo ;

    public Tipo_Tarjeta() {
    }

    public Tipo_Tarjeta(int id_tipo_tarjeta, String descripcion, int activo) {
        this.id_tipo_tarjeta = id_tipo_tarjeta;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public int getId_tipo_tarjeta() {
        return id_tipo_tarjeta;
    }

    public void setId_tipo_tarjeta(int id_tipo_tarjeta) {
        this.id_tipo_tarjeta = id_tipo_tarjeta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    

    
}
