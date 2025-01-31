/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package CapaLogica;

/**
 *
 * @author Sebas
 */
public enum TipoUsuario {
    //tipos de usuarios que se peuden crear
    ADMINISTRADOR("Administrador"),
    VENDEDOR("Vendedor"),
    USUARIO_REGULAR("Regular");

    private String tipo;

    private TipoUsuario(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
