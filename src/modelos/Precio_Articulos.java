/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author DELL
 */
public class Precio_Articulos {

    private int precio_articulo;
    private int id_articulo;


    
    private int sucursal;
    private int articulo;
    private int minorista;
    private int mayorista;
    private String nombre;
    private int cantidad;
    private String codigo_barra;

  

    public Precio_Articulos(int precio_articulo, int sucursal, int articulo, int minorista, int mayorista, String nombre, int cantidad) {
        this.precio_articulo = precio_articulo;
        this.sucursal = sucursal;
        this.articulo = articulo;
        this.minorista = minorista;
        this.mayorista = mayorista;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Precio_Articulos(int id_articulo, int minorista, int mayorista, String nombre, int cantidad) {
        this.id_articulo = id_articulo;
        this.minorista = minorista;
        this.mayorista = mayorista;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Precio_Articulos(int id_articulo, int minorista, int mayorista, String nombre, int cantidad, String codigo_barra) {
        this.id_articulo = id_articulo;
        this.minorista = minorista;
        this.mayorista = mayorista;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.codigo_barra = codigo_barra;
    }

    
  
 

    public Precio_Articulos() {
    }

    

    public int getPrecio_articulo() {
        return precio_articulo;
    }

    public void setPrecio_articulo(int precio_articulo) {
        this.precio_articulo = precio_articulo;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public int getArticulo() {
        return articulo;
    }

    public void setArticulo(int articulo) {
        this.articulo = articulo;
    }

    public int getMinorista() {
        return minorista;
    }

    public void setMinorista(int minorista) {
        this.minorista = minorista;
    }

    public int getMayorista() {
        return mayorista;
    }

    public void setMayorista(int mayorista) {
        this.mayorista = mayorista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }


    

    
    

    
  

    

    
    
}
