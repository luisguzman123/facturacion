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
public class Stock_Articulo {
    private int stock_articulo;
    private int sucursal;
    private int articulo;
    private int cantidad;

    public Stock_Articulo(int stock_articulo, int sucursal, int articulo, int cantidad) {
        this.stock_articulo = stock_articulo;
        this.sucursal = sucursal;
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    public int getStock_articulo() {
        return stock_articulo;
    }

    public void setStock_articulo(int stock_articulo) {
        this.stock_articulo = stock_articulo;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    

   
}
