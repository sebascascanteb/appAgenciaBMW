/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaVista;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Estudiante
 */
public class MiModeloTabla extends DefaultTableModel{

    public MiModeloTabla(String[] filas,int columnas){
        super(filas,columnas);
    }    
    
    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }
}
