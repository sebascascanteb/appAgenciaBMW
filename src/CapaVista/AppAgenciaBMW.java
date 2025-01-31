/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CapaVista;

import utilitarios.UtilitarioVentana;


public class AppAgenciaBMW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         JFrmVentanaPrincipal oFrmVentanaPrincipal = new JFrmVentanaPrincipal();
        
        //Aplicar el estilo de las ventanas
        UtilitarioVentana.aplicarEstiloVentas(3);
        
        //Centrar la ventana principal y mostrar al usuario
        UtilitarioVentana.centrarVentanaJFrame(oFrmVentanaPrincipal, true);
    }
    
}
