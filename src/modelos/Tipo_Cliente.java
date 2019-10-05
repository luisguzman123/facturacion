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
public class Tipo_Cliente {
    
     
    private int id_tipo_cliente;
    private String descripcion;
    private int activo ;

    public Tipo_Cliente() {
    }

    public Tipo_Cliente(int id_tipo_cliente, String descripcion, int activo) {
        this.id_tipo_cliente = id_tipo_cliente;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Tipo_Cliente(int id_tipo_cliente, String descripcion) {
        this.id_tipo_cliente = id_tipo_cliente;
        this.descripcion = descripcion;
    }

    public Tipo_Cliente(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    public int getId_tipo_cliente() {
        return id_tipo_cliente;
    }

    public void setId_tipo_cliente(int id_tipo_cliente) {
        this.id_tipo_cliente = id_tipo_cliente;
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
