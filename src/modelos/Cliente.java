/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Jere
 */
public class Cliente {
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String cedula;
    private String ruc;
    private String telefono;
    private String direccion;
    private String correo;
    private int activo;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre, String apellido, String cedula, String ruc, String telefono, String direccion, String correo, int activo) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.ruc = ruc;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.activo = activo;
    }

    public Cliente(String nombre, String apellido, String cedula, String ruc, String telefono, String direccion, String correo, int activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.ruc = ruc;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.activo = activo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    
    
}
