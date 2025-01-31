package CapaVista;

import CapaLogica.ETipoVehiculo;
import CapaLogica.Partes;
import CapaLogica.Vehiculo;
import CapaVista.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilitarios.UtilitarioVentana;
import utilitarios.UtilitarioVentana;
import utilitarios.ValidadorFormatos;
import utilitarios.ValidadorFormatos;

public class jPanMantenimientoVehiculo extends javax.swing.JPanel {

    private MiModeloTabla dtmModeloTable = new MiModeloTabla(
            new String[]{"Codigo", "Modelo", "Tipo de Vehiculo", "Precio"}, 0);         
    private MiModeloTabla dtmModeloTablePartes = new MiModeloTabla(
            new String[]{"Codigo", "Descripcion", "Estado", "Precio"}, 0);

    /**
     * Creates new form jPanAdministrador
     */
    public jPanMantenimientoVehiculo() {
        initComponents();
        llenarTablaVehiculos();
        llenarTablaPartes();
        jTableVehiculos.setModel(dtmModeloTable);
    }

    public void limpiarCampos() {
        txtCodigo.setText("");
        txtModelo.setText("");
        txtPrecio.setText("");
        buttonGroup1.clearSelection();
    }

    private void llenarTablaPartes() {
        try {
            //Llama al método que llena la lista con los  del ArrayList
            //Llena la tabla con los  que se grabaron en el ArrayList
            dtmModeloTablePartes.setRowCount(0);//Limpia la tabla
            Object[] datos = new Object[4];
            //Obtiene el arrayList con la lista de los  que están en el archivo
            ArrayList<Partes> lista = Partes.listadoPartes();
            for (int i = 0; i < lista.size(); i++) {

                datos[0] = lista.get(i).getCodigo();
                datos[1] = lista.get(i).getDescripcion();
                datos[2] = lista.get(i).getEstado();
                datos[3] = lista.get(i).getPrecio();

                dtmModeloTablePartes.addRow(datos);

                jTablePartes.setModel(dtmModeloTablePartes);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al llenar la tabla de Partes\n"
                    + "el programa se cerrará consulte con el administrador\n"
                    + e.toString());
        }
    }

    private void llenarTablaVehiculos() {
        try {
            //Llama al método que llena la lista con los  del ArrayList
            //Llena la tabla con los  que se grabaron en el ArrayList
            dtmModeloTable.setRowCount(0);//Limpia la tabla
            Object[] datos = new Object[4];
            //Obtiene el arrayList con la lista de los  que están en el archivo
            ArrayList<Vehiculo> lista = Vehiculo.listadoVehiculo();
            for (int i = 0; i < lista.size(); i++) {

                datos[0] = lista.get(i).getCodigoAuto();
                datos[1] = lista.get(i).getModelo();
                datos[2] = lista.get(i).geteTipoVehiculo();
                datos[3] = lista.get(i).getPrecio();

                dtmModeloTable.addRow(datos);

                jTableVehiculos.setModel(dtmModeloTable);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al llenar la tabla de Vehiculos\n"
                    + "el programa se cerrará consulte con el administrador\n"
                    + e.toString());
        }
    }

    private void llenarTablaVehiculosValoresAproximados() {

        if (ValidadorFormatos.validarVacio(txtCodigo.getText()) && ValidadorFormatos.validarVacio(txtModelo.getText())
                && ValidadorFormatos.validarVacio(String.valueOf(txtPrecio.getText()))) {
            JOptionPane.showMessageDialog(this, "Debe digitar como minimo su Codigo, Modelo, Precio o El tipo de Vehiculo");
            txtCodigo.requestFocus();
            getToolkit().beep();
            return;
        }

        try {
            //Llama al método que llena la lista con los  del ArrayList
            //Llena la tabla con los  que se grabaron en el ArrayList
            dtmModeloTable.setRowCount(0);//Limpia la tabla
            Object[] datos = new Object[4];
            //Obtiene el arrayList con la lista de los  que están en el archivo
            ArrayList<Vehiculo> lista = Vehiculo.listadoVehiculo();
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getModelo().equals(txtModelo.getText()) || lista.get(i).getCodigoAuto().equalsIgnoreCase(txtCodigo.getText())) {
                    datos[0] = lista.get(i).getCodigoAuto();
                    datos[1] = lista.get(i).getModelo();
                    datos[2] = lista.get(i).geteTipoVehiculo();
                    datos[3] = lista.get(i).getPrecio();

                    dtmModeloTable.addRow(datos);

                }
                jTableVehiculos.setModel(dtmModeloTable);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al llenar la tabla de Vehiculos\n"
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
        btnAceptar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVehiculos = new javax.swing.JTable();
        txtPrecio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jCheckFosil = new javax.swing.JCheckBox();
        jCheckElectrico = new javax.swing.JCheckBox();
        jCheckHibrido = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePartes = new javax.swing.JTable();

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

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/CheckNegro.png"))); // NOI18N
        btnAceptar.setText("Agregar");
        btnAceptar.setFocusable(false);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAceptar);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editor.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnModificar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basurero.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscarLupa.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setFocusable(false);
        btnConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnConsultar);

        btnRetroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/retroceder.png"))); // NOI18N
        btnRetroceder.setText("Retroceder Consulta");
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

        add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jTableVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Modelo", "Tipo", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVehiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVehiculos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 1440, 370));

        txtPrecio.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 330, 30));

        jLabel8.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/carro.png"))); // NOI18N
        jLabel8.setText("Modelo");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 94, -1));

        txtModelo.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });
        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloKeyTyped(evt);
            }
        });
        add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 330, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo De Vehiculo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("8-bit Operator+", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        buttonGroup1.add(jCheckFosil);
        jCheckFosil.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        jCheckFosil.setText("Fosil");
        jCheckFosil.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonGroup1.add(jCheckElectrico);
        jCheckElectrico.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        jCheckElectrico.setText("Electrico");
        jCheckElectrico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCheckElectrico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckElectricoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckHibrido);
        jCheckHibrido.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        jCheckHibrido.setText("Hibrido");
        jCheckHibrido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCheckHibrido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckHibridoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckHibrido)
                    .addComponent(jCheckFosil)
                    .addComponent(jCheckElectrico))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckFosil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckElectrico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckHibrido)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel1.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mechanicwrench_118392.png"))); // NOI18N
        jLabel1.setText("Partes Extra");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 160, -1));

        txtCodigo.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 330, 30));

        jLabel2.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/precio.png"))); // NOI18N
        jLabel2.setText("Precio");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 193, 30));

        jLabel4.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/codigo.png"))); // NOI18N
        jLabel4.setText("Codigo");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 94, -1));

        jTablePartes.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablePartes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePartesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePartes);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 960, 400));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        // valida que el campo de texto del nombre no este vacio
        if (ValidadorFormatos.validarVacio(txtCodigo.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar el codigo");
            txtCodigo.requestFocus();
            return;
        }
        
        try {
            ArrayList<Vehiculo> lista = Vehiculo.listadoVehiculo();
            for (Vehiculo vehiculo : lista) {
                if (txtCodigo.getText().equalsIgnoreCase(vehiculo.getCodigoAuto())) {
                    JOptionPane.showMessageDialog(this, "Este Codigo ya existe");
                    return;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(jPanMantenimientoPartes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (ValidadorFormatos.validarVacio(txtModelo.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar el modelo");
            txtModelo.requestFocus();
            return;
        }

        // validar que sean letras 
        // valida que el campo del correo electronico no este vacio
        if (ValidadorFormatos.validarVacio(txtPrecio.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar el precio");
            txtPrecio.requestFocus();
            return;
        }

        //validar que se seleccione 1 de los jCheckBox
        if (!jCheckElectrico.isSelected() && !jCheckFosil.isSelected() && !jCheckHibrido.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de Vehiculo");
            jCheckFosil.requestFocus();
            getToolkit().beep();
            return;
        }
        if (jCheckFosil.isSelected()) {
            //creacion de fosil

            Vehiculo vehiculoFosil = new Vehiculo(txtCodigo.getText(), txtModelo.getText(), Double.parseDouble(txtPrecio.getText()), ETipoVehiculo.FOSIL);
            if (vehiculoFosil != null) { //Revisa si el JDialog construyó el nuevo 
                try {
                    Vehiculo.agregarVehiculo(vehiculoFosil);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el vehiculo\n"
                            + "el programa se cerrará consulte con el administrador\n"
                            + e.toString());
                    // e.printStackTrace();//Muestra la caída
                    System.exit(0);
                }
                //actualiza la tabla de manera que se vea el nuevo 
                llenarTablaVehiculos(); 
                
                limpiarCampos();

            }
        }
        if (jCheckElectrico.isSelected()) {
            //creacion de electrico
            Vehiculo vehiculoElectrico = new Vehiculo(txtCodigo.getText(), txtModelo.getText(), Double.parseDouble(txtPrecio.getText()), ETipoVehiculo.ELECTRICO);
            if (vehiculoElectrico != null) { //Revisa si el JDialog construyó el nuevo 
                try {
                    Vehiculo.agregarVehiculo(vehiculoElectrico);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el vehiculo\n"
                            + "el programa se cerrará consulte con el administrador\n"
                            + e.toString());
                    // e.printStackTrace();//Muestra la caída
                    System.exit(0);
                }
                //actualiza la tabla de manera que se vea el nuevo 
                llenarTablaVehiculos(); 
                
                limpiarCampos();

            }
        }
        if (jCheckHibrido.isSelected()) {
            //creacion de hibrido
            Vehiculo vehiculoHibrido = new Vehiculo(txtCodigo.getText(), txtModelo.getText(), Double.parseDouble(txtPrecio.getText()), ETipoVehiculo.HIBRIDO);
            if (vehiculoHibrido != null) { //Revisa si el JDialog construyó el nuevo 
                try {
                    Vehiculo.agregarVehiculo(vehiculoHibrido);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el vehiculo\n"
                            + "el programa se cerrará consulte con el administrador\n"
                            + e.toString());
                    // e.printStackTrace();//Muestra la caída
                    System.exit(0);
                }
                //actualiza la tabla de manera que se vea el nuevo 
                llenarTablaVehiculos(); 
                limpiarCampos();

            }
        }

        limpiarCampos();

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        // valida que el campo de texto del nombre no este vacio
        if (ValidadorFormatos.validarVacio(txtCodigo.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar el codigo");
            txtCodigo.requestFocus();
            return;
        }

        if (ValidadorFormatos.validarVacio(txtModelo.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar el modelo");
            txtModelo.requestFocus();
            return;
        }

        // validar que sean letras 
        // valida que el campo del correo electronico no este vacio
        if (ValidadorFormatos.validarVacio(txtPrecio.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar el precio");
            txtPrecio.requestFocus();
            return;
        }

        //validar que se seleccione 1 de los jCheckBox
        if (!jCheckElectrico.isSelected() && !jCheckFosil.isSelected() && !jCheckHibrido.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo vehiculo");
            jCheckFosil.requestFocus();
            getToolkit().beep();
            return;
        }

        if (jCheckFosil.isSelected()) {
            //creacion de fosil

            Vehiculo vehiculoFosil = new Vehiculo(txtCodigo.getText(), txtModelo.getText(), Double.parseDouble(txtPrecio.getText()), ETipoVehiculo.FOSIL);
            if (vehiculoFosil != null) { //Revisa si el JDialog construyó el nuevo 
                try {
                    Vehiculo.modificarVehiculo(vehiculoFosil);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el vehiculo\n"
                            + "el programa se cerrará consulte con el administrador\n"
                            + e.toString());
                    // e.printStackTrace();//Muestra la caída
                    System.exit(0);
                }
                //actualiza la tabla de manera que se vea el nuevo 
                llenarTablaVehiculos(); 
                
                limpiarCampos();

            }
        }
        if (jCheckElectrico.isSelected()) {
            //creacion de electrico
            Vehiculo vehiculoElectrico = new Vehiculo(txtCodigo.getText(), txtModelo.getText(), Double.parseDouble(txtPrecio.getText()), ETipoVehiculo.ELECTRICO);
            if (vehiculoElectrico != null) { //Revisa si el JDialog construyó el nuevo 
                try {
                    Vehiculo.modificarVehiculo(vehiculoElectrico);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el vehiculo\n"
                            + "el programa se cerrará consulte con el administrador\n"
                            + e.toString());
                    // e.printStackTrace();//Muestra la caída
                    System.exit(0);
                }
                //actualiza la tabla de manera que se vea el nuevo 
                llenarTablaVehiculos(); 
                
                limpiarCampos();

            }
        }
        if (jCheckHibrido.isSelected()) {
            //creacion de hibrido
            Vehiculo vehiculoHibrido = new Vehiculo(txtCodigo.getText(), txtModelo.getText(), Double.parseDouble(txtPrecio.getText()), ETipoVehiculo.HIBRIDO);
            if (vehiculoHibrido != null) { //Revisa si el JDialog construyó el nuevo 
                try {
                    Vehiculo.modificarVehiculo(vehiculoHibrido);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el vehiculo\n"
                            + "el programa se cerrará consulte con el administrador\n"
                            + e.toString());
                    // e.printStackTrace();//Muestra la caída
                    System.exit(0);
                }
                //actualiza la tabla de manera que se vea el nuevo 
                llenarTablaVehiculos(); 
                limpiarCampos();

            }
        }
        limpiarCampos();

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (jTableVehiculos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el vehiculo a eliminar");
            return;
        }

        String codigo = jTableVehiculos.getValueAt(jTableVehiculos.getSelectedRow(), 0).toString();

        try {
            Vehiculo.eliminarVehiculo(codigo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el vehiculo\n"
                    + "el programa se cerrará consulte con el administrador\n"
                    + e.toString());
            System.exit(0);
        }
        llenarTablaVehiculos(); //actualiza la tabla con el nuevo   

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:

        llenarTablaVehiculosValoresAproximados();

    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        UtilitarioVentana.cerrarPanel(this);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped

    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
        txtPrecio.requestFocus();
    }//GEN-LAST:event_txtModeloActionPerformed

    private void txtModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtModeloKeyTyped

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        txtModelo.requestFocus();
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        //validar que el usuario este digitando solo letras

    }//GEN-LAST:event_txtCodigoKeyTyped

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void jTableVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVehiculosMouseClicked
        // TODO add your handling code here:
        String codigo = jTableVehiculos.getValueAt(jTableVehiculos.getSelectedRow(), 0).toString();
        txtCodigo.setText(codigo);
        String modelo = jTableVehiculos.getValueAt(jTableVehiculos.getSelectedRow(), 1).toString();
        txtModelo.setText(modelo);

        String precio = jTableVehiculos.getValueAt(jTableVehiculos.getSelectedRow(), 3).toString();
        txtPrecio.setText(precio);

        txtCodigo.requestFocus();

    }//GEN-LAST:event_jTableVehiculosMouseClicked

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        llenarTablaVehiculos();
    }//GEN-LAST:event_btnRetrocederActionPerformed

    private void jCheckElectricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckElectricoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckElectricoActionPerformed

    private void jCheckHibridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckHibridoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckHibridoActionPerformed

    private void jTablePartesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePartesMouseClicked
//        // TODO add your handling code here:
//        String codigo = jTablePartes.getValueAt(jTablePartes.getSelectedRow(), 0).toString();
//        txtCodigo.setText(codigo);
//        String modelo = jTablePartes.getValueAt(jTablePartes.getSelectedRow(), 1).toString();
//        txtDescripcion.setText(modelo);
//
//        String precio = jTablePartes.getValueAt(jTablePartes.getSelectedRow(), 3).toString();
//        txtPrecio.setText(precio);
//
//        txtCodigo.requestFocus();
    }//GEN-LAST:event_jTablePartesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckElectrico;
    private javax.swing.JCheckBox jCheckFosil;
    private javax.swing.JCheckBox jCheckHibrido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTable jTablePartes;
    private javax.swing.JTable jTableVehiculos;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
