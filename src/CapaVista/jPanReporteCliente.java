package CapaVista;

import CapaVista.*;
import CapaLogica.Usuario_Cliente;
import CapaLogica.ClienteCoorporativo;
import CapaLogica.ClientePersonal;
import CapaLogica.Pais;
import CapaLogica.TipoUsuario;
import CapaLogica.Usuario;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilitarios.UtilitarioVentana;
import utilitarios.ValidadorFormatos;

public class jPanReporteCliente extends javax.swing.JPanel {

    private MiModeloTabla dtmModeloTable = new MiModeloTabla( //modelo para la tabla
            new String[]{"Identificación", "Nombre", "Clave", "Email", "Pais", "Direccion", "Teléfono", "Tipo Cliente"}, 0);
    ArrayList<Usuario_Cliente> lista = new ArrayList<>(); //arreglo para guardar el archivo con los usuarios
    ArrayList<Usuario> listUsuarios = new ArrayList<>(); //arreglo para guardar solo los usuarios

    /**
     * Creates new form jPanAdministrador
     */
    public jPanReporteCliente() {
        initComponents();
        llenarTablaClientes();
        llenarListaUsuarios();

        jTableClientes.setModel(dtmModeloTable);
    }

    public void llenarListaUsuarios() {
        for (int i = 0; i < lista.size(); i++) {

            listUsuarios.add(lista.get(i).getUsuario());

        }
    }

    public void limpiarCampos() {
        buttonGroup1.clearSelection();

    }

    private void llenarTablaClientes() {
        try {
            //Llama al método que llena la lista con los  del ArrayList
            //Llena la tabla con los  que se grabaron en el ArrayList
            dtmModeloTable.setRowCount(0);//Limpia la tabla
            Object[] datos = new Object[8];
            //Obtiene el arrayList con la lista de los  que están en el archivo
            lista = Usuario_Cliente.listadoUsuario_Clientes();
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getUsuario().getTipoUsuario().equals(TipoUsuario.USUARIO_REGULAR)) {
                    datos[0] = lista.get(i).getIdentificacion();
                    datos[1] = lista.get(i).getUsuario().getNombre();
                    datos[2] = lista.get(i).getUsuario().getClave();
                    datos[3] = lista.get(i).getUsuario().getCorreo();
                    datos[4] = lista.get(i).getUsuario().getPais();
                    datos[5] = lista.get(i).getUsuario().getDireccion();
                    datos[6] = lista.get(i).getUsuario().getTelefono();

                    if (lista.get(i) instanceof ClientePersonal) {
                        datos[7] = "Cliente Personal";
                    }
                    if (lista.get(i) instanceof ClienteCoorporativo) {
                        datos[7] = "Cliente Coorporativo";
                    }

                    dtmModeloTable.addRow(datos);
                }
                jTableClientes.setModel(dtmModeloTable);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al llenar la tabla de Clientes\n"
                    + "el programa se cerrará consulte con el administrador\n"
                    + e.toString());
        }
    }

    private void llenarTablaClientesFiltro() { //metodo para llenar la tabla al seleccionar los filtros del panel

        try {
            
            dtmModeloTable.setRowCount(0);//Limpia la tabla
            Object[] datos = new Object[8];
          
            lista = Usuario_Cliente.listadoUsuario_Clientes();

            if (jChkNumerico.isSelected()) {   //llenado de la tabla con el filtro numerico ascendente 
                lista.sort(Comparator.comparing(Usuario_Cliente::getIdentificacion));
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getUsuario().getTipoUsuario().equals(TipoUsuario.USUARIO_REGULAR)) {   
                        datos[0] = lista.get(i).getIdentificacion();
                        datos[1] = lista.get(i).getUsuario().getNombre();
                        datos[2] = lista.get(i).getUsuario().getClave();
                        datos[3] = lista.get(i).getUsuario().getCorreo();
                        datos[4] = lista.get(i).getUsuario().getPais();
                        datos[5] = lista.get(i).getUsuario().getDireccion();
                        datos[6] = lista.get(i).getUsuario().getTelefono();
                        if (lista.get(i) instanceof ClientePersonal) {
                            datos[7] = "Cliente Personal";
                        }
                        if (lista.get(i) instanceof ClienteCoorporativo) {
                            datos[7] = "Cliente Coorporativo";
                        }

                        dtmModeloTable.addRow(datos);
                    }
                    jTableClientes.setModel(dtmModeloTable);
                }
            }

            if (jChkAlfabetico.isSelected()) { //llenado de la tabla con el filtro alfabetico 
                listUsuarios.sort(Comparator.comparing(Usuario::getNombre));
                for (int i = 0; i < lista.size(); i++) {
                    Usuario_Cliente usuario = Usuario_Cliente.consultarUsuario_Cliente(listUsuarios.get(i).getCorreo(), listUsuarios.get(i).getClave());
                    if (usuario.getUsuario().getTipoUsuario().equals(TipoUsuario.USUARIO_REGULAR)) {
                        datos[0] = usuario.getIdentificacion();
                        datos[1] = usuario.getUsuario().getNombre();
                        datos[2] = usuario.getUsuario().getClave();
                        datos[3] = usuario.getUsuario().getCorreo();
                        datos[4] = usuario.getUsuario().getPais();
                        datos[5] = usuario.getUsuario().getDireccion();
                        datos[6] = usuario.getUsuario().getTelefono();
                        if (usuario instanceof ClientePersonal) {
                            datos[7] = "Cliente Personal";
                        }
                        if (usuario instanceof ClienteCoorporativo) {
                            datos[7] = "Cliente Coorporativo";
                        }

                        dtmModeloTable.addRow(datos);

                    }
                    jTableClientes.setModel(dtmModeloTable);

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al llenar la tabla de Clientes\n"
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
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jChkAlfabetico = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jChkNumerico = new javax.swing.JCheckBox();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnRetroceder = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();

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
        jToolBar1.add(jSeparator2);

        buttonGroup1.add(jChkAlfabetico);
        jChkAlfabetico.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jChkAlfabetico.setText("Orden Alfabetico");
        jChkAlfabetico.setFocusable(false);
        jChkAlfabetico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jChkAlfabetico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jChkAlfabetico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkAlfabeticoActionPerformed(evt);
            }
        });
        jToolBar1.add(jChkAlfabetico);
        jToolBar1.add(jSeparator3);

        buttonGroup1.add(jChkNumerico);
        jChkNumerico.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jChkNumerico.setText("Orden Numerico");
        jChkNumerico.setFocusable(false);
        jChkNumerico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jChkNumerico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jChkNumerico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkNumericoActionPerformed(evt);
            }
        });
        jToolBar1.add(jChkNumerico);
        jToolBar1.add(jSeparator4);

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

        btnSalir.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
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

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "Cédula", "Email", "Teléfono", "Dirección", "País", "Constraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1330, 370));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        UtilitarioVentana.cerrarPanel(this);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_jTableClientesMouseClicked

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        llenarTablaClientes();
        limpiarCampos();
    }//GEN-LAST:event_btnRetrocederActionPerformed

    private void jChkNumericoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkNumericoActionPerformed
        // TODO add your handling code here:
        llenarTablaClientesFiltro();
    }//GEN-LAST:event_jChkNumericoActionPerformed

    private void jChkAlfabeticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkAlfabeticoActionPerformed
        // TODO add your handling code here:
        llenarTablaClientesFiltro();
    }//GEN-LAST:event_jChkAlfabeticoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jChkAlfabetico;
    private javax.swing.JCheckBox jChkNumerico;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
