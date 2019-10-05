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
public class Categoria_Articulo {
    
    private int id_categoria_articulo;
    private String descripcion;
    private int activo ;

    public Categoria_Articulo() {
    }

    public Categoria_Articulo(int id_categoria_articulo, String descripcion, int activo) {
        this.id_categoria_articulo = id_categoria_articulo;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Categoria_Articulo(int id_categoria_articulo, String descripcion) {
        this.id_categoria_articulo = id_categoria_articulo;
        this.descripcion = descripcion;
    }

    public Categoria_Articulo(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    public int getId_categoria_articulo() {
        return id_categoria_articulo;
    }

    public void setId_categoria_articulo(int id_categoria_articulo) {
        this.id_categoria_articulo = id_categoria_articulo;
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
