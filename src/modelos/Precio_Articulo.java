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
public class Precio_Articulo {

    private int precio_articulo;
    private int sucursal;
    private int articulo;
    private int minorista;
    private int mayorista;

    public Precio_Articulo(int precio_articulo, int sucursal, int articulo, int minorista, int mayorita) {
        this.precio_articulo = precio_articulo;
        this.sucursal = sucursal;
        this.articulo = articulo;
        this.minorista = minorista;
        this.mayorista = mayorita;
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

    public void setMayorista(int mayorita) {
        this.mayorista = mayorita;
    }

    
    
}
