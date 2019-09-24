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
public class Usuario {
     
    private int id_usuario;
    private String nombre_apellido;
    private String usuario;
    private String pass;
    private int id_sucursal;
    private int activo ;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre_apellido, String usuario, String pass, int id_sucursal, int activo) {
        this.id_usuario = id_usuario;
        this.nombre_apellido = nombre_apellido;
        this.usuario = usuario;
        this.pass = pass;
        this.id_sucursal = id_sucursal;
        this.activo = activo;
    }

    public Usuario(int id_usuario, String nombre_apellido, String usuario, String pass, int id_sucursal) {
        this.id_usuario = id_usuario;
        this.nombre_apellido = nombre_apellido;
        this.usuario = usuario;
        this.pass = pass;
        this.id_sucursal = id_sucursal;
    }

    
    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

   

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    
}
