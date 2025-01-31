/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.FacturasBD;
import CapaLogica.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utilitarios.Formatos;

public class Factura implements Serializable {

    private static int CONT_FACTURA = 1;
    private  int numeroFactura;
    private Usuario_Cliente cliente;
    private double descuento;
    private double subTotal;
    private double total;
    private double impuesto;
    private Date fecha;
    private Vehiculo vehiculo;
    private ArrayList<Partes> listPartes = new ArrayList<>();

    public Factura(int numeroFactura, Usuario_Cliente cliente, double descuento, double subTotal, double total, double impuesto, Vehiculo vehiculo,ArrayList<Partes> listPartes ) {
        this.cliente = cliente;
        this.descuento = descuento;
        this.subTotal = subTotal;
        this.total = total;
        this.impuesto = impuesto;
        this.fecha = fecha;
        this.vehiculo = vehiculo;
        this.numeroFactura = numeroFactura;
        this.listPartes = listPartes;
        fecha = new Date();

    }
    
    

    public ArrayList<Partes> getListPartes() {
        return listPartes;
    }

    public void setListPartes(ArrayList<Partes> listPartes) {
        this.listPartes = listPartes;
    }

    public static int getCONT_FACTURA() {
        return CONT_FACTURA;
    }

    public static void setCONT_FACTURA(int CONT_FACTURA) {
        Factura.CONT_FACTURA = CONT_FACTURA;
    }

    public  int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Usuario_Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Usuario_Cliente cliente) {
        this.cliente = cliente;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public static Factura consultarFactura(int num) throws Exception {
        Factura f1 = FacturasBD.getInstance().consultarFacturas(num);
        return f1;
    }

    public static void agregarFactura(Factura f) throws Exception {
        FacturasBD.getInstance().agregarFactura(f);
    }

    public static void eliminarFactura(int num) throws Exception {
        FacturasBD.getInstance().eliminarFactura(num);
    }

    public static void modificarFactura(Factura f) throws Exception {
        FacturasBD.getInstance().modificarFactura(f);
    }

    public static ArrayList<Factura> listadoFacturas() throws Exception {
        ArrayList<Factura> arrayF = FacturasBD.getInstance().listaFacturas();
        return arrayF;

    }
    
    @Override
    public String toString() {
        String vHilera = "";
        
        vHilera+=  "\n=======================================================================================================================================" +
                   "\nNo. de Factura : " + this.numeroFactura+
                   "\nCliente        : " + this.cliente.getIdentificacion()+
                   "\n                 " + this.cliente.getUsuario().getNombre()+
                   "\nSubTotal       : " + this.subTotal+
                   "\nDescuento      : " + this.descuento+
                   "\nImpuesto       : " + this.impuesto+
                   "\nTotal          : " + this.total+
                   "\n=======================================================================================================================================" +
                   "\n                                                       *** Auto Registrado ***"+
                   "\n"+ this.vehiculo.toString()+
                   "\n---------------------------------------------------------------------------------------------------------------------------------------\n"+
                   "\n=======================================================================================================================================" +
                   "\n                                                       *** Partes Registradas ***";
                   for (Partes partes : this.listPartes) {
                       vHilera+="\n"+partes.toString();
                    }
                   
        vHilera+=  "\n---------------------------------------------------------------------------------------------------------------------------------------\n";
        return vHilera;
    }
    
    

//    public double precioTotalExtras() {
//        double vTotal = 0.0;
//        
//        for (DetalleFactura oDetalleFactura : listaDetalleFactura) {
//            vTotal += oDetalleFactura.calcularSubTotalDetalleFactura();
//        }
//        return vTotal;
//    }
//    // implementar
//    public double calculaDescuento() {
//        return 0;
//    }
//    public double calculoImpuesto(){
//        return ( this.precioTotalExtras() - this.calculaDescuento() ) * 0.13;
//    }
//    
//    public double calculoTotalAuto(){
//        return (this.precioTotalExtras() - this.calculaDescuento()) + this.calculoImpuesto();
//    }
//    @Override
//    public String toString(){
//        String vHilera = "";
//        Boolean vHayDetalleFactura = false;
//        
//        //Información general de la factura        
//        vHilera += "\n=======================================================================================================================================" +
//                   "\nNo. de Factura : " + Formatos.conFormatoEntero( this.numeroFactura ) +
//                   "\nCliente        : " + this.cliente.toString() +
//                   "\nMoneda         : " + this.tipoModena.toString() +
//                   "\n=======================================================================================================================================" +
//                   "\n                                                       *** Productos Registrados ***" + 
//                   "\n---------------------------------------------------------------------------------------------------------------------------------------\n";
//        
//        //Iterar con un for-each el detalle de la factura
//        for(DetalleFactura oLineaDetalleFactura : this.listaDetalleFactura){
//            vHilera += oLineaDetalleFactura.toString();
//            vHayDetalleFactura = true;
//        }
//        
//        //Si no hay detalle de la factura agrega la siguiente hilera
//        if (!vHayDetalleFactura) {
//            vHilera += "*** No hay detalle de productos vendidos en la factura ***\n";
//        }
//        
//        //Imprimir los grandes totales
//        vHilera += "------------------------------------------------------------------------" +
//                   "\nPrecio total de los artículos extras              : " + 
//                   Formatos.conFormatoPuntoFlotante(this.precioTotalExtras())+
//                   "\nMonto del descuento    : " + 
//                   Formatos.conFormatoPuntoFlotante( this.calculaDescuento() ) +
//                   "\n------------------------------------------------------------------------" + 
//                   "\nSub Total Factura      : " + 
//                   this.tipoModena.getSimboloMoneda() + " " + 
//                   Formatos.conFormatoPuntoFlotante( this.precioTotalExtras() - this.calculaDescuento() ) +                   
//                   "\nImpuesto de Ventas     : " + 
//                   this.tipoModena.getSimboloMoneda() + " " + 
//                   Formatos.conFormatoPuntoFlotante( this.calculoImpuesto() ) +
//                   "\nTotal a Pagar Factura  : " + 
//                   this.tipoModena.getSimboloMoneda() + " " + 
//                   Formatos.conFormatoPuntoFlotante( this.calculoTotalAuto() ) +
//                   "\n------------------------------------------------------------------------";
//        
//        return vHilera;
//    }

    
}
