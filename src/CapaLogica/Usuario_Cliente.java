/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.Usuario_ClienteBD;
import java.io.Serializable;
import java.util.ArrayList;

public class Usuario_Cliente implements Serializable {

    private Usuario usuario;
    private String identificacion;

    public Usuario_Cliente(Usuario usuario, String identificacion) {
        this.usuario = usuario;
        this.identificacion = identificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public static Usuario_Cliente consultarUsuario_Cliente(String correo, String clave) throws Exception {
        Usuario_Cliente uc1 = Usuario_ClienteBD.getInstance().consultarUsuario_Cliente(correo, clave);
        return uc1;
    }

    public static boolean consultarUsuario_ClienteBoolean(String correo, String clave) throws Exception {
        Usuario_Cliente uc1 = Usuario_ClienteBD.getInstance().consultarUsuario_Cliente(correo, clave);
        if (uc1 != null) {
            return true;
        } else {
            return false;
        }
    }

    public static void agregarUsuario_Cliente(Usuario_Cliente uc) throws Exception {
        Usuario_ClienteBD.getInstance().agregarUsuario_Cliente(uc);
    }

    public static void eliminarUsuario_Cliente(String correo) throws Exception {
        Usuario_ClienteBD.getInstance().eliminarUsuario_Cliente(correo);
    }

    public static void modificarUsuario_Cliente(Usuario_Cliente uc) throws Exception {
        Usuario_ClienteBD.getInstance().modificarUsuario_Cliente(uc);
    }

    public static ArrayList<Usuario_Cliente> listadoUsuario_Clientes() throws Exception {
        ArrayList<Usuario_Cliente> arrayUc = Usuario_ClienteBD.getInstance().listaUsuario_Clientes();
        return arrayUc;

    }

    @Override
    public String toString() {
        return "Usuario_Cliente{" + "usuario=" + usuario + ", identificacion=" + identificacion + '}';
    }

}
