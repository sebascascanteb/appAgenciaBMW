/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.VehiculoBD;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import utilitarios.Formatos;

public class Vehiculo implements Serializable {

    private String codigoAuto;
    private String modelo;
    private double precio;
    private ETipoVehiculo eTipoVehiculo;
    private static List<Partes> ArrayPartes;

    public Vehiculo(String codigoAuto, String modelo, double precio, ETipoVehiculo eTipoVehiculo) {
        this.codigoAuto = codigoAuto;
        this.modelo = modelo;
        this.precio = precio;
        this.eTipoVehiculo = eTipoVehiculo;
    }

  
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public ETipoVehiculo geteTipoVehiculo() {
        return eTipoVehiculo;
    }

    public void seteTipoVehiculo(ETipoVehiculo eTipoVehiculo) {
        this.eTipoVehiculo = eTipoVehiculo;
    }

    public List<Partes> getArrayPartes() {
        return ArrayPartes;
    }

    public String getCodigoAuto() {
        return codigoAuto;
    }

    public void setCodigoAuto(String codigoAuto) {
        this.codigoAuto = codigoAuto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void agregarParte(Partes parte) {
        ArrayPartes.add(parte);
    }

    public double calculaDescuento() {
        return 0;
    }

    public static Vehiculo consultarVehiculo(String codigo) throws Exception {
        Vehiculo v1 = VehiculoBD.getInstance().consultarVehiculo(codigo);
        return v1;
    }

    public static boolean consultarVehiculoBoolean(String codigo) throws Exception {
        Vehiculo v1 = VehiculoBD.getInstance().consultarVehiculo(codigo);
        if (v1 != null) {
            return true;
        } else {
            return false;
        }
    }

    public static void agregarVehiculo(Vehiculo v) throws Exception {
        VehiculoBD.getInstance().agregarVehiculo(v);
    }

    public static void eliminarVehiculo(String codigo) throws Exception {
        VehiculoBD.getInstance().eliminarVehiculo(codigo);
    }

    public static void modificarVehiculo(Vehiculo v) throws Exception {
        VehiculoBD.getInstance().modificarVehiculo(v);
    }

    public static ArrayList<Vehiculo> listadoVehiculo() throws Exception {
        ArrayList<Vehiculo> arrayV = VehiculoBD.getInstance().listaVehiculo();
        return arrayV;

    }

    @Override
    public String toString() {
        return "Codigo: " + codigoAuto + " || " + "Modelo: " + modelo + " || " + "Tipo de Vehiculo: " + eTipoVehiculo + " || " + "Precio: " + precio;
    }

    public String toStringPartes() {
        return this.codigoAuto + " - " + this.modelo
                + "[" + Formatos.conFormatoPuntoFlotante(this.precio) + "]";
    }
}
