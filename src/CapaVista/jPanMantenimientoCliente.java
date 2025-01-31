package CapaVista;

import CapaLogica.Usuario_Cliente;
import CapaLogica.ClienteCoorporativo;
import CapaLogica.ClientePersonal;
import CapaLogica.Pais;
import CapaLogica.TipoUsuario;
import CapaLogica.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilitarios.UtilitarioVentana;
import utilitarios.ValidadorFormatos;

public class jPanMantenimientoCliente extends javax.swing.JPanel {

    private static ClienteCoorporativo clienteCoorporativo = null;
    private static ClientePersonal clientePersonal = null;

//    DefaultTableModel modeloTabla = new DefaultTableModel();
    private MiModeloTabla dtmModeloTable = new MiModeloTabla(
            new String[]{"Identificación", "Nombre", "Clave", "Email", "Pais", "Direccion", "Teléfono", "Tipo Cliente"}, 0);

    /**
     * Creates new form jPanAdministrador
     */
    public jPanMantenimientoCliente() {
        initComponents();
        llenarComboPais();
        llenarTablaClientes();
        jTableClientes.setModel(dtmModeloTable);
    }

    public void llenarComboPais() {
        jCboPais.removeAllItems();
        for (Pais pais : Pais.values()) {
            jCboPais.addItem(pais);
        }
        jCboPais.setSelectedIndex(-1);
    }

    public void limpiarCampos() {
        txtCedula.setText("");
        txtCorreoElectronico.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtNombre.setText("");
        jCboPais.setSelectedIndex(-1);
        JPassContrasena.setText("");
        JPassConfirmacionContrasena.setText("");
        buttonGroup1.clearSelection();
    }

    private void llenarTablaClientes() {
        try {
            //Llama al método que llena la lista con los  del ArrayList
            //Llena la tabla con los  que se grabaron en el ArrayList
            dtmModeloTable.setRowCount(0);//Limpia la tabla
            Object[] datos = new Object[8];
            //Obtiene el arrayList con la lista de los  que están en el archivo
            ArrayList<Usuario_Cliente> lista = Usuario_Cliente.listadoUsuario_Clientes();
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

//                    modeloTabla.addRow(datos);//Agrega el arreglo como una nueva fila de la tabla
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

    private void llenarTablaClientesValoresAproximados() {

        if (ValidadorFormatos.validarVacio(txtNombre.getText()) && ValidadorFormatos.validarVacio(txtCedula.getText())
                && ValidadorFormatos.validarVacio(txtCorreoElectronico.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar como minimo su nonmbre, cedula o correo");
            txtNombre.requestFocus();
            getToolkit().beep();
            return;
        }

        try {
            //Llama al método que llena la lista con los  del ArrayList
            //Llena la tabla con los  que se grabaron en el ArrayList
            dtmModeloTable.setRowCount(0);//Limpia la tabla
            Object[] datos = new Object[8];
            //Obtiene el arrayList con la lista de los  que están en el archivo
            ArrayList<Usuario_Cliente> lista = Usuario_Cliente.listadoUsuario_Clientes();
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getUsuario().getTipoUsuario().equals(TipoUsuario.USUARIO_REGULAR)) {
                    if (lista.get(i).getIdentificacion().equals(txtCedula.getText()) || lista.get(i).getUsuario().getNombre().equalsIgnoreCase(txtNombre.getText())
                            || lista.get(i).getUsuario().getCorreo().equalsIgnoreCase(txtCorreoElectronico.getText())) {
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

//                    modeloTabla.addRow(datos);//Agrega el arreglo como una nueva fila de la tabla
                        dtmModeloTable.addRow(datos);
                    }
                }
                jTableClientes.setModel(dtmModeloTable);
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
        btnAceptar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtCorreoElectronico = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JPassContrasena = new javax.swing.JPasswordField();
        txtDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JPassConfirmacionContrasena = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jCheckCorporativo = new javax.swing.JCheckBox();
        jCheckPersonal = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jCboPais = new javax.swing.JComboBox<>();

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

        add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, -1, -1));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 370, 1330, 370));

        jLabel3.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pais.png"))); // NOI18N
        jLabel3.setText("Pais");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 185, 30));

        txtCorreoElectronico.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        txtCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoElectronicoActionPerformed(evt);
            }
        });
        txtCorreoElectronico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoElectronicoKeyTyped(evt);
            }
        });
        add(txtCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 330, 30));

        jLabel4.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PasswordIcon.png"))); // NOI18N
        jLabel4.setText("Contraseña");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 185, 30));

        jLabel7.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/direccionm.png"))); // NOI18N
        jLabel7.setText("Dirección");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        JPassContrasena.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        JPassContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPassContrasenaActionPerformed(evt);
            }
        });
        JPassContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JPassContrasenaKeyTyped(evt);
            }
        });
        add(JPassContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 330, 30));

        txtDireccion.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 330, 30));

        jLabel8.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jLabel8.setText("Cédula");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 94, -1));

        txtCedula.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 330, 30));

        jLabel5.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PasswordIcon.png"))); // NOI18N
        jLabel5.setText("Confirmación");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 185, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarioB.png"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        JPassConfirmacionContrasena.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        JPassConfirmacionContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPassConfirmacionContrasenaActionPerformed(evt);
            }
        });
        JPassConfirmacionContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JPassConfirmacionContrasenaKeyTyped(evt);
            }
        });
        add(JPassConfirmacionContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 330, 30));

        jLabel10.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/telefono.png"))); // NOI18N
        jLabel10.setText("Teléfono");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 180, 37));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo De Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("8-bit Operator+", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        buttonGroup1.add(jCheckCorporativo);
        jCheckCorporativo.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        jCheckCorporativo.setText("Corporativo");
        jCheckCorporativo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonGroup1.add(jCheckPersonal);
        jCheckPersonal.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        jCheckPersonal.setText("Personal");
        jCheckPersonal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckCorporativo)
                    .addComponent(jCheckPersonal))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jCheckCorporativo)
                .addGap(18, 18, 18)
                .addComponent(jCheckPersonal)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        jLabel1.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jLabel1.setText("Nombre");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 94, -1));

        txtNombre.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 330, 30));

        jLabel2.setFont(new java.awt.Font("8-bit Operator+", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Email.png"))); // NOI18N
        jLabel2.setText("Correo Electronico");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 193, 30));

        txtTelefono.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 330, 30));

        jCboPais.setFont(new java.awt.Font("8-bit Operator+", 0, 12)); // NOI18N
        jCboPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboPaisActionPerformed(evt);
            }
        });
        add(jCboPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 330, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        String contrasenaUsuario = "";
        // valida que el campo de texto del nombre no este vacio
        if (ValidadorFormatos.validarVacio(txtNombre.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar su nombre");
            txtNombre.requestFocus();
            return;
        }

        if (ValidadorFormatos.validarVacio(txtCedula.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar su cedula");
            txtCedula.requestFocus();
            return;
        }
        if (ValidadorFormatos.validarVacio(txtDireccion.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar su direccion");
            txtDireccion.requestFocus();
            return;
        }
        if (ValidadorFormatos.validarVacio(txtTelefono.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar su telefono");
            txtTelefono.requestFocus();
            return;
        }

        // validar que sean letras 
        // valida que el campo del correo electronico no este vacio
        if (ValidadorFormatos.validarVacio(txtCorreoElectronico.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar su correo electronico");
            txtCorreoElectronico.requestFocus();
            return;
        }
        //valida que la contraseña sea mayor a 0 y menor a 12
        if (String.valueOf(JPassConfirmacionContrasena.getPassword()).length() >= 0 && String.valueOf(JPassConfirmacionContrasena.getPassword()).length() <= 12) {
            contrasenaUsuario = String.valueOf(JPassConfirmacionContrasena.getPassword());
        }

        // validar que el combo box no esté vacio
        if (jCboPais.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el país");
            jCboPais.requestFocus();
            return;
        }

        // validar que el pastfiel de contraseña no este vacio
        if (ValidadorFormatos.validarVacio(String.valueOf(JPassContrasena.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la contraseña");
            JPassContrasena.requestFocus();
            return;
        }

        //Validar que el pastfiel de confirmacion contraseña no este vacio
        if (ValidadorFormatos.validarVacio(String.valueOf(JPassConfirmacionContrasena.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Debe confirmar su contraseña");
            JPassConfirmacionContrasena.requestFocus();
            return;
        }

        if (String.valueOf(JPassContrasena.getPassword()).equalsIgnoreCase(String.valueOf(JPassConfirmacionContrasena.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Contraseña exitosa");
//           
        } else {
            JOptionPane.showMessageDialog(this, "La contraseña debe coincidir");
        }

        // validar correo con @ y .com y (gmail||hotmail)
        if (txtCorreoElectronico.getText().contains("@") && txtCorreoElectronico.getText().contains(".com")) {
            if (txtCorreoElectronico.getText().contains("gmail") || txtCorreoElectronico.getText().contains("hotmail")) {
                JOptionPane.showMessageDialog(this, "Su correo es correcto");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Su correo no es válido");
            txtCorreoElectronico.requestFocus();
            txtCorreoElectronico.selectAll();
        }

        //validar que JPassContrasena este entre 8 a 12 caracteres
        if (String.valueOf(JPassContrasena.getPassword()).length() >= 8 && String.valueOf(JPassContrasena.getPassword()).length() <= 12) {
            JOptionPane.showMessageDialog(this, "Su contraseña a sido exitosa");
        } else {
            JOptionPane.showMessageDialog(this, "La contraseña debe contener entre 8 a 12 caracteres");
            JPassContrasena.selectAll();
            JPassContrasena.requestFocus();
            return;
        }

        //validar que JPassConfirmacionContrasena este entre 8 a 12 caracteres
        if (String.valueOf(JPassConfirmacionContrasena.getPassword()).length() >= 8 && String.valueOf(JPassConfirmacionContrasena.getPassword()).length() <= 12) {
            JOptionPane.showMessageDialog(this, "Su contraseña a sido exitosa");
        } else {
            JOptionPane.showMessageDialog(this, "La contraseña debe contener entre 8 a 12 caracteres");
            JPassConfirmacionContrasena.selectAll();
            JPassConfirmacionContrasena.requestFocus();
            return;
        }

        //variables validadoras para la clave (deben de estar las 3 en True para que sea correcta)
        boolean validador1 = false;
        boolean validador2 = false;
        boolean validador3 = false;

        //validacion de minusculas, mayusculas y digitos
        for (int i = 0; i < contrasenaUsuario.length(); i++) {
            char a = contrasenaUsuario.charAt(i);
            if (Character.isLowerCase(a)) {
                validador1 = true;
            }
            if (Character.isUpperCase(a)) {
                validador2 = true;
            }
            if (Character.isDigit(a)) {
                validador3 = true;
            }
        }
        //validar que los validadores de caracteres sean Verdaderos los 3
        if (!(validador1 == true && validador2 == true && validador3 == true)) {
            JOptionPane.showMessageDialog(this, "La clave debe contener almenos una letra Mayuscula, una Minuscula y un Numero");
            JPassContrasena.requestFocus();
            JPassContrasena.setText("");
            JPassConfirmacionContrasena.setText("");
            getToolkit().beep();
            return;
        }

        //validar que se seleccione 1 de los jCheckBox
        if (!jCheckPersonal.isSelected() && !jCheckCorporativo.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo cliente");
            jCheckCorporativo.requestFocus();
            getToolkit().beep();
            return;
        }
        if (jCheckCorporativo.isSelected()) {
            //creacion de cliente coorporativo

            Pais paisSeleccionado = (Pais) jCboPais.getSelectedItem();
            Usuario usuarioCoorporativo = new Usuario(txtCorreoElectronico.getText(), contrasenaUsuario, txtNombre.getText(), paisSeleccionado, //falta el pais///////////////////////////////////////
                    txtDireccion.getText(), txtTelefono.getText(), TipoUsuario.USUARIO_REGULAR);
            clienteCoorporativo = new ClienteCoorporativo(usuarioCoorporativo, txtCedula.getText());
            if (clienteCoorporativo != null) { //Revisa si el JDialog construyó el nuevo 
                try {
                    Usuario_Cliente.agregarUsuario_Cliente(clienteCoorporativo);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el usuario\n"
                            + "el programa se cerrará consulte con el administrador\n"
                            + e.toString());
                    // e.printStackTrace();//Muestra la caída
                    System.exit(0);
                }
                //actualiza la tabla de manera que se vea el nuevo 
                llenarTablaClientes(); 
                
            }
        }
        if (jCheckPersonal.isSelected()) {
            //creacion de cliente personal
            Pais paisSeleccionado = (Pais) jCboPais.getSelectedItem();
            Usuario usuarioPersonal = new Usuario(txtCorreoElectronico.getText(), contrasenaUsuario, txtNombre.getText(), paisSeleccionado, //falta el pais///////////////////////////////////////
                    txtDireccion.getText(), txtTelefono.getText(), TipoUsuario.USUARIO_REGULAR);
            clientePersonal = new ClientePersonal(usuarioPersonal, txtCedula.getText());
            if (clientePersonal != null) { //Revisa si el JDialog construyó el nuevo 
                try {
                    Usuario_Cliente.agregarUsuario_Cliente(clientePersonal);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el usuario\n"
                            + "el programa se cerrará consulte con el administrador\n"
                            + e.toString());
                    // e.printStackTrace();//Muestra la caída
                    System.exit(0);
                }
                //actualiza la tabla de manera que se vea el nuevo 
                llenarTablaClientes(); 
                

            }
        }
        limpiarCampos();


    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        String contrasenaUsuario = "";
        // valida que el campo de texto del nombre no este vacio
        if (ValidadorFormatos.validarVacio(txtNombre.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar su nombre");
            txtNombre.requestFocus();
            return;
        }

        if (ValidadorFormatos.validarVacio(txtCedula.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar su cedula");
            txtCedula.requestFocus();
            return;
        }
        if (ValidadorFormatos.validarVacio(txtDireccion.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar su direccion");
            txtDireccion.requestFocus();
            return;
        }
        if (ValidadorFormatos.validarVacio(txtTelefono.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar su telefono");
            txtTelefono.requestFocus();
            return;
        }

        // validar que sean letras 
        // valida que el campo del correo electronico no este vacio
        if (ValidadorFormatos.validarVacio(txtCorreoElectronico.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar su correo electronico");
            txtCorreoElectronico.requestFocus();
            return;
        }
        //valida que la contraseña sea mayor a 0 y menor a 12
        if (String.valueOf(JPassConfirmacionContrasena.getPassword()).length() >= 0 && String.valueOf(JPassConfirmacionContrasena.getPassword()).length() <= 12) {
            contrasenaUsuario = String.valueOf(JPassConfirmacionContrasena.getPassword());
        }

        // validar que el combo box no esté vacio
        if (jCboPais.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el país");
            jCboPais.requestFocus();
            return;
        }

        // validar que el pastfiel de contraseña no este vacio
        if (ValidadorFormatos.validarVacio(String.valueOf(JPassContrasena.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la contraseña");
            JPassContrasena.requestFocus();
            return;
        }

        //Validar que el pastfiel de confirmacion contraseña no este vacio
        if (ValidadorFormatos.validarVacio(String.valueOf(JPassConfirmacionContrasena.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Debe confirmar su contraseña");
            JPassConfirmacionContrasena.requestFocus();
            return;
        }

        if (String.valueOf(JPassContrasena.getPassword()).equalsIgnoreCase(String.valueOf(JPassConfirmacionContrasena.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Contraseña exitosa");
//           
        } else {
            JOptionPane.showMessageDialog(this, "La contraseña debe coincidir");
        }

        // validar correo con @ y .com y (gmail||hotmail)
        if (txtCorreoElectronico.getText().contains("@") && txtCorreoElectronico.getText().contains(".com")) {
            if (txtCorreoElectronico.getText().contains("gmail") || txtCorreoElectronico.getText().contains("hotmail")) {
                JOptionPane.showMessageDialog(this, "Su correo es correcto");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Su correo no es válido");
            txtCorreoElectronico.requestFocus();
            txtCorreoElectronico.selectAll();
        }

        //validar que JPassContrasena este entre 8 a 12 caracteres
        if (String.valueOf(JPassContrasena.getPassword()).length() >= 8 && String.valueOf(JPassContrasena.getPassword()).length() <= 12) {
            JOptionPane.showMessageDialog(this, "Su contraseña a sido exitosa");
        } else {
            JOptionPane.showMessageDialog(this, "La contraseña debe contener entre 8 a 12 caracteres");
            JPassContrasena.selectAll();
            JPassContrasena.requestFocus();
            return;
        }

        //validar que JPassConfirmacionContrasena este entre 8 a 12 caracteres
        if (String.valueOf(JPassConfirmacionContrasena.getPassword()).length() >= 8 && String.valueOf(JPassConfirmacionContrasena.getPassword()).length() <= 12) {
            JOptionPane.showMessageDialog(this, "Su contraseña a sido exitosa");
        } else {
            JOptionPane.showMessageDialog(this, "La contraseña debe contener entre 8 a 12 caracteres");
            JPassConfirmacionContrasena.selectAll();
            JPassConfirmacionContrasena.requestFocus();
            return;
        }

        //variables validadoras para la clave (deben de estar las 3 en True para que sea correcta)
        boolean validador1 = false;
        boolean validador2 = false;
        boolean validador3 = false;

        //validacion de minusculas, mayusculas y digitos
        for (int i = 0; i < contrasenaUsuario.length(); i++) {
            char a = contrasenaUsuario.charAt(i);
            if (Character.isLowerCase(a)) {
                validador1 = true;
            }
            if (Character.isUpperCase(a)) {
                validador2 = true;
            }
            if (Character.isDigit(a)) {
                validador3 = true;
            }
        }
        //validar que los validadores de caracteres sean Verdaderos los 3
        if (!(validador1 == true && validador2 == true && validador3 == true)) {
            JOptionPane.showMessageDialog(this, "La clave debe contener almenos una letra Mayuscula, una Minuscula y un Numero");
            JPassContrasena.requestFocus();
            JPassContrasena.setText("");
            JPassConfirmacionContrasena.setText("");
            getToolkit().beep();
            return;
        }

        //validar que se seleccione 1 de los jCheckBox
        if (!jCheckPersonal.isSelected() && !jCheckCorporativo.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo cliente");
            jCheckCorporativo.requestFocus();
            getToolkit().beep();
            return;
        }
        if (jCheckCorporativo.isSelected()) {
            //creacion de cliente coorporativo

            Pais paisSeleccionado = (Pais) jCboPais.getSelectedItem();
            Usuario usuarioCoorporativo = new Usuario(txtCorreoElectronico.getText(), contrasenaUsuario, txtNombre.getText(), paisSeleccionado, 
                    txtDireccion.getText(), txtTelefono.getText(), TipoUsuario.USUARIO_REGULAR);
            clienteCoorporativo = new ClienteCoorporativo(usuarioCoorporativo, txtCedula.getText());
            if (clienteCoorporativo != null) { //Revisa si el JDialog construyó el nuevo 
                try {
                    Usuario_Cliente.modificarUsuario_Cliente(clienteCoorporativo);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el usuario\n"
                            + "el programa se cerrará consulte con el administrador\n"
                            + e.toString());
                    // e.printStackTrace();//Muestra la caída
                    System.exit(0);
                }
                //actualiza la tabla de manera que se vea el nuevo 
                llenarTablaClientes(); 
                

            }
        }
        if (jCheckPersonal.isSelected()) {
            //creacion de cliente personal
            Pais paisSeleccionado = (Pais) jCboPais.getSelectedItem();
            Usuario usuarioPersonal = new Usuario(txtCorreoElectronico.getText(), contrasenaUsuario, txtNombre.getText(), paisSeleccionado, 
                    txtDireccion.getText(), txtTelefono.getText(), TipoUsuario.USUARIO_REGULAR);
            clientePersonal = new ClientePersonal(usuarioPersonal, txtCedula.getText());
            if (clientePersonal != null) { //Revisa si el JDialog construyó el nuevo 
                try {
                    Usuario_Cliente.modificarUsuario_Cliente(clientePersonal);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el usuario\n"
                            + "el programa se cerrará consulte con el administrador\n"
                            + e.toString());
                    // e.printStackTrace();//Muestra la caída
                    System.exit(0);
                }
                //actualiza la tabla de manera que se vea el nuevo 
                llenarTablaClientes(); 
                

            }
        }

        limpiarCampos();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (jTableClientes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el cliente a eliminar");
            return;
        }

        String correo = jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 3).toString();

        try {
            Usuario_Cliente.eliminarUsuario_Cliente(correo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el Cliente\n"
                    + "el programa se cerrará consulte con el administrador\n"
                    + e.toString());
            System.exit(0);
        }
        llenarTablaClientes(); //actualiza la tabla con el nuevo   

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:

        llenarTablaClientesValoresAproximados();


    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        UtilitarioVentana.cerrarPanel(this);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoElectronicoActionPerformed
        // TODO add your handling code here:
        txtTelefono.requestFocus();
    }//GEN-LAST:event_txtCorreoElectronicoActionPerformed

    private void txtCorreoElectronicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoElectronicoKeyTyped

    }//GEN-LAST:event_txtCorreoElectronicoKeyTyped

    private void JPassContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPassContrasenaActionPerformed
        // TODO add your handling code here:
        JPassConfirmacionContrasena.requestFocus();
    }//GEN-LAST:event_JPassContrasenaActionPerformed

    private void JPassContrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPassContrasenaKeyTyped
        //tope maximo de 12 carateres en la clave
        if (JPassContrasena.getText().length() >= 12) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_JPassContrasenaKeyTyped

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
        jCboPais.requestFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
        txtCorreoElectronico.requestFocus();
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        // TODO add your handling code here:
        //valida que el usuario solo digite numeros
        if (Character.isLetter(evt.getKeyChar())) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Debe digitar solo números la cedula");
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void JPassConfirmacionContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPassConfirmacionContrasenaActionPerformed
        // TODO add your handling code here:
        btnAceptar.doClick();
    }//GEN-LAST:event_JPassConfirmacionContrasenaActionPerformed

    private void JPassConfirmacionContrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPassConfirmacionContrasenaKeyTyped
        //tope maximo de 12 carateres en la clave
        if (JPassConfirmacionContrasena.getText().length() >= 12) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_JPassConfirmacionContrasenaKeyTyped

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtCedula.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        //validar que el usuario este digitando solo letras
        if (Character.isDigit(evt.getKeyChar())) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Debe digitar solo letras");
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
        txtDireccion.requestFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        //valida que el usuario solo digite numeros
        if (Character.isLetter(evt.getKeyChar())) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Debe digitar solo números en el telefono");
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void jCboPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboPaisActionPerformed
        // TODO add your handling code here:
        JPassContrasena.requestFocus();
    }//GEN-LAST:event_jCboPaisActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        // TODO add your handling code here:
        String identificacion = jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 0).toString();
        txtCedula.setText(identificacion);
        String nombre = jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 1).toString();
        txtNombre.setText(nombre);
        JPassContrasena.setText("");
        JPassConfirmacionContrasena.setText("");
        String email = jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 3).toString();
        txtCorreoElectronico.setText(email);
        jCboPais.setSelectedIndex(-1);
        String direccion = jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 5).toString();
        txtDireccion.setText(direccion);
        String telefono = jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 6).toString();
        txtTelefono.setText(telefono);
        txtNombre.requestFocus();

    }//GEN-LAST:event_jTableClientesMouseClicked

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        llenarTablaClientes();
    }//GEN-LAST:event_btnRetrocederActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JPassConfirmacionContrasena;
    private javax.swing.JPasswordField JPassContrasena;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Pais> jCboPais;
    private javax.swing.JCheckBox jCheckCorporativo;
    private javax.swing.JCheckBox jCheckPersonal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
