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
public class Banco {
    
    private int id_banco;
    private String descripcion;
    private int activo ;

    public Banco() {
    }

    public Banco(int id_banco, String descripcion, int activo) {
        this.id_banco = id_banco;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Banco(int id_banco, String descripcion) {
        this.id_banco = id_banco;
        this.descripcion = descripcion;
    }

    public Banco(String descripcion) {
        this.descripcion = descripcion;
    }
   
    
    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
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
