/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package CapaLogica;

/**
 *
 * @author Sebas
 */
public enum Pais {
    ALEMANIA("Alemania"),
    BRASIL("Brasil"),
    CHINA("China"),
    INDIA("India"),
    SUDAFRICA("Sudáfrica"),
    REINO_UNIDO("Reino Unido"),
    ESTADOS_UNIDOS("Estados Unidos"),
    MEXICO("México"),
    COSTA_RICA("Costa Rica");
    
    private String descripcion;

    private Pais(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
