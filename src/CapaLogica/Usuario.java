/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.Usuario_ClienteBD;
import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

    private String correo;
    private String clave;
    private String nombre;
    private Pais pais;
    private String direccion;
    private String telefono;
    private TipoUsuario tipoUsuario;

    public Usuario(String correo, String clave, String nombre, Pais pais, String direccion, String telefono, TipoUsuario tipoUsuario) {
        this.correo = correo;
        this.clave = clave;
        this.nombre = nombre;
        this.pais = pais;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return this.correo + " - " + this.clave;
    }

    public String toStringArchivo() {
        return this.correo + ";" + this.clave;
    }

    

}
