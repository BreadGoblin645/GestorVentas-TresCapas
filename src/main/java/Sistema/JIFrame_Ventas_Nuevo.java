
package Sistema;

import CapaLogica.VentasDAO;
import CapaLogica.VentasLogica;
import CapaLogica.ClientesLogica;
import CapaLogica.ClientesDAO;
import CapaLogica.InventarioDAO;
import CapaLogica.InventarioLogica;
import java.awt.Color;
import java.beans.PropertyVetoException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alexhp
 */

public class JIFrame_Ventas_Nuevo extends javax.swing.JInternalFrame {

    private HashMap<String, Integer> clienteMap = new HashMap<>();

    private JIFrame_Ventas frameVentas;
    VentasLogica ventasLogica;
    VentasDAO ventasDAO;

    public JIFrame_Ventas_Nuevo(JIFrame_Ventas frameVentas) {
        initComponents();
        ventasLogica = new VentasLogica();
        ventasDAO = new VentasDAO();
        this.frameVentas = frameVentas;
        llenarComboBoxClientes();
        llenarComboBoxMarcas();
    }
    
    private void llenarComboBoxClientes() {
        try {
            ResultSet rs = new ClientesLogica().obtenerClientes();
            cbox_Clientes.removeAllItems();
            cbox_Clientes.addItem("-Select-");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombreCompleto = rs.getString("nombre") + ", " + rs.getString("apellido");
                clienteMap.put(nombreCompleto, id);
                cbox_Clientes.addItem(nombreCompleto);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los clientes: " + e.getMessage());
        }
    }
    
    private void llenarComboBoxMarcas() {
        try {
            cbox_marca.removeAllItems();
            cbox_marca.addItem("-Marca-");
            ResultSet rs = new InventarioLogica().obtenerMarcas();
            while (rs.next()) {
                cbox_marca.addItem(rs.getString("marca"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar marcas: " + e.getMessage());
        }
    }
    
    private void llenarComboBoxModelosPorMarca(String marca) {
        try {
            cbox_modelo.removeAllItems();
            cbox_modelo.addItem("-Modelo-");
            ResultSet rs = new InventarioLogica().obtenerModelosPorMarca(marca);
            while (rs.next()) {
                cbox_modelo.addItem(rs.getString("modelo"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar modelos: " + e.getMessage());
        }
    }
    
    private void llenarComboBoxAnosPorModelo(String marca, String modelo) {
        try {
            cbox_ano.removeAllItems();
            cbox_ano.addItem("-Año-");
            ResultSet rs = new InventarioLogica().obtenerAnosPorModelo(marca, modelo);
            while (rs.next()) {
                cbox_ano.addItem(String.valueOf(rs.getInt("ano")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar años: " + e.getMessage());
        }
    }
    
    private void obtenerIdInventario(String marca, String modelo, int ano) {
        try {
            ResultSet rs = new InventarioLogica().obtenerIdInventario(marca, modelo, ano);
            if (rs.next()) {
                int idInventario = rs.getInt("id");
                txt_id_inventorio.setText("");
                txt_id_inventorio.setText(String.valueOf(idInventario));
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró inventario para esta combinación.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al obtener ID de inventario: " + e.getMessage());
        }
    }
    
    private void LimpiarCampos(){
       cbox_Clientes.setSelectedIndex(0);
       txtCantidad.setText("");
       txtTotal.setText("");
       txtFecha.setText("");

       // Restablecer ComboBox de marcas, modelos y años
       cbox_marca.setSelectedIndex(0);
       cbox_modelo.removeAllItems();
       cbox_modelo.addItem("-Modelo-");
       cbox_modelo.setEnabled(false);
       cbox_ano.removeAllItems();
       cbox_ano.addItem("-Año-");
       cbox_ano.setEnabled(false);

       // Limpiar el campo de ID de inventario
       txt_id_inventorio.setText("-----");

       // Enfocar el primer campo
       cbox_Clientes.requestFocus();
    }
    
    public boolean validarFecha(String fecha) {
        String patron = "\\d{4}-\\d{2}-\\d{2}";
        if (!fecha.matches(patron)) {
            return false;
        }
        try {
            // Intentar parsear la fecha
            java.time.LocalDate.parse(fecha);
            return true;
        } catch (Exception e) {
            return false;
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

        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        lbl_ID_Cliente = new javax.swing.JLabel();
        lblVehiculo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        cbox_Clientes = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        cbx_nuevo = new javax.swing.JCheckBox();
        cbox_modelo = new javax.swing.JComboBox<>();
        cbox_marca = new javax.swing.JComboBox<>();
        cbox_ano = new javax.swing.JComboBox<>();
        txt_id_inventorio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agregar entrada de ventas");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaKeyReleased(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblCantidad.setText("Cantidad:");

        lbl_ID_Cliente.setText("id_Cliente:");

        lblVehiculo.setText("Vehiculo:");

        lblFecha.setText("Fecha:");

        lblTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblTitulo.setText("Agregar registro de Venta");

        lblTotal.setText("Total:");

        cbox_Clientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-" }));

        btnNuevo.setText("Agregar");
        btnNuevo.setEnabled(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        cbx_nuevo.setText("Nuevo Cliente");
        cbx_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_nuevoActionPerformed(evt);
            }
        });

        cbox_modelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Modelo-" }));
        cbox_modelo.setEnabled(false);
        cbox_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_modeloActionPerformed(evt);
            }
        });

        cbox_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Marca-" }));
        cbox_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_marcaActionPerformed(evt);
            }
        });

        cbox_ano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Ano-" }));
        cbox_ano.setEnabled(false);
        cbox_ano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_anoActionPerformed(evt);
            }
        });

        txt_id_inventorio.setText("-----");
        txt_id_inventorio.setEnabled(false);

        jLabel1.setText("id_Inventario:");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 2, 10)); // NOI18N
        jLabel2.setText("*Formato: yyyy-MM-dd");
        jLabel2.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblVehiculo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbox_ano, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbox_marca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbox_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_id_inventorio, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_ID_Cliente)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnActualizar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbx_nuevo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnNuevo)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCantidad)
                                            .addComponent(lblTotal))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(129, 129, 129)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lblTitulo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbox_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblFecha)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbx_nuevo)
                            .addComponent(btnNuevo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_ID_Cliente)
                            .addComponent(cbox_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFecha)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCantidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotal))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVehiculo))
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(cbox_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbox_ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_inventorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        String clienteSeleccionado = cbox_Clientes.getSelectedItem().toString();
        if (clienteSeleccionado.equals("-Select-")) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente.");
            return;
        }
        int idCliente = clienteMap.get(clienteSeleccionado); // Obtener el ID del cliente seleccionado

        String idInventarioTexto = txt_id_inventorio.getText().trim();
        
        String fecha = txtFecha.getText().trim();
        if (!validarFecha(fecha)) {
            JOptionPane.showMessageDialog(this, "La fecha ingresada no es válida. Por favor, usa el formato yyyy-MM-dd.");
            return;
        }

        
        String cantidadTexto = txtCantidad.getText().trim();
        
        
        String totalTexto = txtTotal.getText().trim();

        if (idInventarioTexto.isEmpty() || cantidadTexto.isEmpty() || fecha.isEmpty() || totalTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, llena todos los campos.");
            return;
        }

        try {
            int idInventario = Integer.parseInt(idInventarioTexto);
            int cantidad = Integer.parseInt(cantidadTexto);
            double total = Double.parseDouble(totalTexto);

            // Asignar valores al DAO
            ventasDAO.setIdCliente(idCliente);
            ventasDAO.setIdInventario(idInventario);
            ventasDAO.setCantidad(cantidad);
            ventasDAO.setTotal(total);
            ventasDAO.setFecha(fecha);

            // Guardar en la base de datos
            boolean resultado = ventasLogica.insertarVenta(ventasDAO);
            if (resultado) {
                JOptionPane.showMessageDialog(this, "Error al agregar la venta.");
            } else {
                JOptionPane.showMessageDialog(this, "Venta agregada correctamente.");
                frameVentas.actualizarTablaVentas();
                LimpiarCampos();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Verifica que cantidad y total sean numéricos.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        LimpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbx_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_nuevoActionPerformed
        // TODO add your handling code here:
        if (cbx_nuevo.isSelected()){
            btnNuevo.setEnabled(true);
        } else {
            btnNuevo.setEnabled(false);
        }
    }//GEN-LAST:event_cbx_nuevoActionPerformed

    private void cbox_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_modeloActionPerformed
        // TODO add your handling code here:
        Object modeloSeleccionado = cbox_modelo.getSelectedItem();
        Object marcaSeleccionada = cbox_marca.getSelectedItem();

        if (modeloSeleccionado != null && !modeloSeleccionado.toString().equals("-Modelo-")) {
            try {
                llenarComboBoxAnosPorModelo(marcaSeleccionada.toString(), modeloSeleccionado.toString());
                cbox_ano.setEnabled(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cargar años: " + e.getMessage());
            }
        } else {
            cbox_ano.removeAllItems();
            cbox_ano.addItem("-Año-");
            cbox_ano.setEnabled(false);
        }

    }//GEN-LAST:event_cbox_modeloActionPerformed

    private void cbox_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_marcaActionPerformed
        // TODO add your handling code here:
        Object marcaSeleccionada = cbox_marca.getSelectedItem();
        if (marcaSeleccionada != null && !marcaSeleccionada.toString().equals("-Marca-")) {
            llenarComboBoxModelosPorMarca(marcaSeleccionada.toString());
            cbox_modelo.setEnabled(true);
        } else {
            cbox_modelo.setEnabled(false);
            cbox_ano.setEnabled(false);
        }
    }//GEN-LAST:event_cbox_marcaActionPerformed

    private void cbox_anoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_anoActionPerformed
        // TODO add your handling code here:
        Object anoSeleccionado = cbox_ano.getSelectedItem();
        Object marcaSeleccionada = cbox_marca.getSelectedItem();
        Object modeloSeleccionado = cbox_modelo.getSelectedItem();

        if (anoSeleccionado != null && !anoSeleccionado.toString().equals("-Año-")) {
            try {
                obtenerIdInventario(marcaSeleccionada.toString(), modeloSeleccionado.toString(), Integer.parseInt(anoSeleccionado.toString()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al obtener el ID de inventario: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_cbox_anoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try {
            JIFrame_Clientes_Nuevo nuevoClienteForm = new JIFrame_Clientes_Nuevo(null);

            if (this.getDesktopPane() != null) {
                this.getDesktopPane().add(nuevoClienteForm); // Agregar al DesktopPane
            }

            nuevoClienteForm.setVisible(true);
            nuevoClienteForm.toFront(); 
            nuevoClienteForm.setSelected(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al abrir el formulario: " + e.getMessage());
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try {
            llenarComboBoxClientes();
            llenarComboBoxMarcas();

            cbox_modelo.removeAllItems();
            cbox_modelo.addItem("-Modelo-");
            cbox_modelo.setEnabled(false);

            cbox_ano.removeAllItems();
            cbox_ano.addItem("-Año-");
            cbox_ano.setEnabled(false);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar datos: " + e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtFechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyReleased
        // TODO add your handling code here:
        String texto = txtFecha.getText().replaceAll("[^\\d]", ""); // Eliminar caracteres no numéricos

        if (texto.length() > 8) {
            texto = texto.substring(0, 8); // Limitar a 8 caracteres numéricos
        }

        // Formatear al estilo yyyy-MM-dd
        StringBuilder formateado = new StringBuilder();
        if (texto.length() >= 1) {
            formateado.append(texto.substring(0, Math.min(4, texto.length())));
        }
        if (texto.length() >= 5) {
            formateado.append("-");
            formateado.append(texto.substring(4, Math.min(6, texto.length())));
        }
        if (texto.length() >= 7) {
            formateado.append("-");
            formateado.append(texto.substring(6));
        }

        txtFecha.setText(formateado.toString());
    }//GEN-LAST:event_txtFechaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbox_Clientes;
    private javax.swing.JComboBox<String> cbox_ano;
    private javax.swing.JComboBox<String> cbox_marca;
    private javax.swing.JComboBox<String> cbox_modelo;
    private javax.swing.JCheckBox cbx_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVehiculo;
    private javax.swing.JLabel lbl_ID_Cliente;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txt_id_inventorio;
    // End of variables declaration//GEN-END:variables
}
