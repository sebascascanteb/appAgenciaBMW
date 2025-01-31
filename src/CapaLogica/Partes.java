/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.PartesBD;
import java.io.Serializable;
import java.util.ArrayList;

public class Partes implements Serializable {

    private String codigo;
    private String descripcion;
    private Estado estado;
    private double precio;

    public Partes(String codigo, String descripcion, Estado estado, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.precio = precio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + " || " + "Descripcion: " + descripcion + " || " + "Estado: " + estado + " || " + "Precio: " + precio;
    }

    public static Partes consultarPartes(String codigo) throws Exception {
        Partes p1 = PartesBD.getInstance().consultarPartes(codigo);
        return p1;
    }

    public static boolean consultarParteBoolean(String codigo) throws Exception {
        Partes p1 = PartesBD.getInstance().consultarPartes(codigo);
        if (p1 != null) {
            return true;
        } else {
            return false;
        }
    }

    public static void agregarParte(Partes p) throws Exception {
        PartesBD.getInstance().agregarParte(p);
    }

    public static void eliminarParte(String codigo) throws Exception {
        PartesBD.getInstance().eliminarParte(codigo);
    }

    public static void modificarParte(Partes p) throws Exception {
        PartesBD.getInstance().modificarParte(p);
    }

    public static ArrayList<Partes> listadoPartes() throws Exception {
        ArrayList<Partes> arrayP = PartesBD.getInstance().listaPartes();
        return arrayP;

    }

}
