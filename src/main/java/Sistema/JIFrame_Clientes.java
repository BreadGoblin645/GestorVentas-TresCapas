
package Sistema;

import CapaLogica.ClientesDAO;
import CapaLogica.ClientesLogica;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexhp
 */

public class JIFrame_Clientes extends javax.swing.JInternalFrame {

    private int nivelUsuario;  
    private JDesktopPane desktopPane;
    private MainFrame mainFrame;
    ClientesLogica clientesLogica;
    ClientesDAO clientesDAO;

    public JIFrame_Clientes(JDesktopPane desktopPane, int nivelUsuario) {
        initComponents();
        this.clientesLogica = new ClientesLogica();
        this.desktopPane = desktopPane;
        this.nivelUsuario = nivelUsuario;
        
    }
    
    private void agregarFormulario() {
        JIFrame_Clientes_Nuevo formNuevoCliente = new JIFrame_Clientes_Nuevo(this);
        desktopPane.add(formNuevoCliente);
        formNuevoCliente.setVisible(true);
    }
   
    public void actualizarTablaClientes() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Correo");
        modelo.addColumn("Teléfono");

        try {
            ResultSet resultado = clientesLogica.obtenerClientes();
            while (resultado.next()) {
                modelo.addRow(new Object[]{
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("telefono"),
                    resultado.getString("correo")       
                });
            }
            jTable_Clientes.setModel(modelo);
        } catch (Exception e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }
    
    private void buscarCliente(String criterio) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Correo");
        

        try {
            ResultSet resultado = clientesLogica.buscarCliente(criterio);
            while (resultado.next()) {
                modelo.addRow(new Object[]{
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("telefono"),
                    resultado.getString("correo")
                });
            }
            jTable_Clientes.setModel(modelo);
        } catch (Exception e) {
            System.out.println("Error al buscar cliente: " + e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        lblShow = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTable_Clientes = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        lblNotaBuscar = new javax.swing.JLabel();
        btnAdmin = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestor de Clientes");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setText("BUSCAR:");

        lblShow.setText("VER LISTA CLIENTES:");

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jTable_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ClientesMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(jTable_Clientes);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblNotaBuscar.setText("*Buscar por Nombre o Apellido");
        lblNotaBuscar.setEnabled(false);

        btnAdmin.setText("Administrar");
        btnAdmin.setEnabled(false);
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblShow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                                .addComponent(btnAdmin))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNotaBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir)
                                .addGap(10, 10, 10)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrar)
                    .addComponent(lblShow)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdmin)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNotaBuscar)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        actualizarTablaClientes();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        agregarFormulario();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jTable_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ClientesMouseClicked
        // TODO add your handling code here:
        // Verificar si hay una fila seleccionada
        int filaSeleccionada = jTable_Clientes.getSelectedRow();

        if (filaSeleccionada != -1) {
            btnAdmin.setEnabled(true);
        }
    }//GEN-LAST:event_jTable_ClientesMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String criterio = txtBuscar.getText().trim();

        if (criterio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un criterio de búsqueda.");
            return;
        }
        buscarCliente(criterio);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = jTable_Clientes.getSelectedRow();
        if (filaSeleccionada != -1) { 
            // Obtener los datos de la fila seleccionada
            int id = (int) jTable_Clientes.getValueAt(filaSeleccionada, 0);
            String nombre = jTable_Clientes.getValueAt(filaSeleccionada, 1).toString();
            String apellido = jTable_Clientes.getValueAt(filaSeleccionada, 2).toString();
            String telefono = jTable_Clientes.getValueAt(filaSeleccionada, 3).toString();
            String correo = jTable_Clientes.getValueAt(filaSeleccionada, 4).toString();
            // Crear y mostrar el formulario de gestión de clientes
            JIFrame_Clientes_Gestor JIFgestorCliente = new JIFrame_Clientes_Gestor(this, nivelUsuario, 
                    id, nombre, apellido, telefono, correo);
            desktopPane.add(JIFgestorCliente); 
            JIFgestorCliente.setVisible(true);
        }
    }//GEN-LAST:event_btnAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable_Clientes;
    private javax.swing.JLabel lblNotaBuscar;
    private javax.swing.JLabel lblShow;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

}
