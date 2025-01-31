package CapaVista;

import CapaLogica.ClienteCoorporativo;
import CapaLogica.ClientePersonal;
import CapaVista.*;
import CapaVista.*;
import CapaLogica.Estado;
import CapaLogica.Factura;
import CapaLogica.TipoUsuario;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilitarios.UtilitarioVentana;
import utilitarios.UtilitarioVentana;
import utilitarios.ValidadorFormatos;
import utilitarios.ValidadorFormatos;

public class jPanReporteFacturas extends javax.swing.JPanel {

    private MiModeloTabla dtmModeloTable = new MiModeloTabla(
            new String[]{"Num Factura", "Cliente", "Total", "Fecha","Vehiculo"}, 0);         

    /**
     * Creates new form jPanAdministrador
     */
    public jPanReporteFacturas() {
        initComponents();
        llenarTablaFacturas();
        jTableFacturas.setModel(dtmModeloTable);
    }

    public void limpiarCampos(){
        buttonGroup1.clearSelection();
    }
    

    

    private void llenarTablaFacturas() {
        try {
            //Llama al método que llena la lista con los  del ArrayList
            //Llena la tabla con los  que se grabaron en el ArrayList
            dtmModeloTable.setRowCount(0);//Limpia la tabla
            Object[] datos = new Object[5];
            //Obtiene el arrayList con la lista de los  que están en el archivo
            ArrayList<Factura> lista = Factura.listadoFacturas();
            for (int i = 0; i < lista.size(); i++) {

                datos[0] = lista.get(i).getNumeroFactura();
                datos[1] = lista.get(i).getCliente().getUsuario().getNombre();
                datos[2] = lista.get(i).getTotal();
                datos[3] = lista.get(i).getFecha();
                datos[4] = lista.get(i).getVehiculo().getModelo();

                dtmModeloTable.addRow(datos);

                jTableFacturas.setModel(dtmModeloTable);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al llenar la tabla de Factura\n"
                    + "el programa se cerrará consulte con el administrador\n"
                    + e.toString());
        }
    }
    
    private void llenarTablaFacturasFiltroCoorporativo() {
        
        try {
            
            //Llama al método que llena la lista con los  del ArrayList
            //Llena la tabla con los  que se grabaron en el ArrayList
            dtmModeloTable.setRowCount(0);//Limpia la tabla
            Object[] datos = new Object[5];
            //Obtiene el arrayList con la lista de los  que están en el archivo
            ArrayList<Factura> lista = Factura.listadoFacturas();
            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).getCliente()instanceof ClienteCoorporativo){
                datos[0] = lista.get(i).getNumeroFactura();
                datos[1] = lista.get(i).getCliente().getUsuario().getNombre();
                datos[2] = lista.get(i).getTotal();
                datos[3] = lista.get(i).getFecha();
                datos[4] = lista.get(i).getVehiculo().getModelo();

                dtmModeloTable.addRow(datos);
                
                jTableFacturas.setModel(dtmModeloTable);
            }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al llenar la tabla de Factura\n"
                    + "el programa se cerrará consulte con el administrador\n"
                    + e.toString());
        }
    }

    private void llenarTablaFacturasFiltroPersonal() {
        
        try {
            
            //Llama al método que llena la lista con los  del ArrayList
            //Llena la tabla con los  que se grabaron en el ArrayList
            dtmModeloTable.setRowCount(0);//Limpia la tabla
            Object[] datos = new Object[5];
            //Obtiene el arrayList con la lista de los  que están en el archivo
            ArrayList<Factura> lista = Factura.listadoFacturas();
            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).getCliente()instanceof ClientePersonal){
                datos[0] = lista.get(i).getNumeroFactura();
                datos[1] = lista.get(i).getCliente().getUsuario().getNombre();
                datos[2] = lista.get(i).getTotal();
                datos[3] = lista.get(i).getFecha();
                datos[4] = lista.get(i).getVehiculo().getModelo();

                dtmModeloTable.addRow(datos);
                
                jTableFacturas.setModel(dtmModeloTable);
            }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al llenar la tabla de Factura\n"
                    + "el programa se cerrará consulte con el administrador\n"
                    + e.toString());
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jChkCoorporativo = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jChkPersonal = new javax.swing.JCheckBox();
        btnRetroceder = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFacturas = new javax.swing.JTable();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setRollover(true);

        buttonGroup1.add(jChkCoorporativo);
        jChkCoorporativo.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jChkCoorporativo.setText("Coorporativo");
        jChkCoorporativo.setFocusable(false);
        jChkCoorporativo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jChkCoorporativo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jChkCoorporativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkCoorporativoActionPerformed(evt);
            }
        });
        jToolBar1.add(jChkCoorporativo);
        jToolBar1.add(jSeparator2);

        buttonGroup1.add(jChkPersonal);
        jChkPersonal.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jChkPersonal.setText("Personal");
        jChkPersonal.setFocusable(false);
        jChkPersonal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jChkPersonal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jChkPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkPersonalActionPerformed(evt);
            }
        });
        jToolBar1.add(jChkPersonal);

        btnRetroceder.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        btnRetroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/retroceder.png"))); // NOI18N
        btnRetroceder.setText("Retroceder Filtro");
        btnRetroceder.setFocusable(false);
        btnRetroceder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRetroceder.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRetroceder);
        jToolBar1.add(jSeparator1);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Salida.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setFocusable(false);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalir);

        add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTableFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Estado", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFacturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFacturas);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1340, 370));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        UtilitarioVentana.cerrarPanel(this);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void jTableFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFacturasMouseClicked
        // TODO add your handling code here:
        

    }//GEN-LAST:event_jTableFacturasMouseClicked

    private void jChkCoorporativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkCoorporativoActionPerformed
        // TODO add your handling code here:
        llenarTablaFacturasFiltroCoorporativo();
    }//GEN-LAST:event_jChkCoorporativoActionPerformed

    private void jChkPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkPersonalActionPerformed
        // TODO add your handling code here:
        llenarTablaFacturasFiltroPersonal();
    }//GEN-LAST:event_jChkPersonalActionPerformed

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        llenarTablaFacturas();
        limpiarCampos();
    }//GEN-LAST:event_btnRetrocederActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jChkCoorporativo;
    private javax.swing.JCheckBox jChkPersonal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTable jTableFacturas;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
