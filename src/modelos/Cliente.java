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
    
    
}
