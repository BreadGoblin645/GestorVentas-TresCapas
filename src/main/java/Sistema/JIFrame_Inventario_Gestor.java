
package Sistema;

import CapaLogica.InventarioDAO;
import CapaLogica.InventarioLogica;
import javax.swing.JOptionPane;



/**
 *
 * @author alexhp
 */
public class JIFrame_Inventario_Gestor extends javax.swing.JInternalFrame {

    InventarioLogica inventarioLogica;
    InventarioDAO inventarioDAO;
    private JIFrame_Inventario frameInventario;

    
    public JIFrame_Inventario_Gestor(JIFrame_Inventario frameInventario, int nivelUsuario, int id,String marca, String modelo, String tipo, int ano, int existencia) {
        initComponents();
        this.frameInventario = frameInventario;      
        this.inventarioLogica = new InventarioLogica();
        this.inventarioDAO = new InventarioDAO();
        
        // Establecer los valores en los camposve
        this.inventarioDAO.setId(id);
        cbox_Marca.setSelectedItem(marca);
        txtModelo.setText(modelo);
        cbox_Tipo.setSelectedItem(tipo); 
        cbox_Ano.setSelectedItem(String.valueOf(ano)); 
        txtStock.setText(String.valueOf(existencia));
        
        // Configurar acceso al botón Eliminar según el nivel de usuario
        if (nivelUsuario == 1) { // Usuario no tiene permisos para eliminar
            btnEliminar.setEnabled(false);
        } else if (nivelUsuario == 2 || nivelUsuario == 3) { // Asistente y Administrador tienen permisos
            btnEliminar.setEnabled(true);
        }
    }
    
    private void limpiarCampos(){
        cbox_Marca.setSelectedIndex(0);
        txtModelo.setText("");
        cbox_Tipo.setSelectedIndex(0);
        cbox_Ano.setSelectedIndex(0);
        txtStock.setText("");
        
    }
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMarca = new javax.swing.JLabel();
        lblExistencia = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        cbox_Ano = new javax.swing.JComboBox<>();
        cbox_Marca = new javax.swing.JComboBox<>();
        lblAno = new javax.swing.JLabel();
        cbox_Tipo = new javax.swing.JComboBox<>();
        txtModelo = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestor de Inventario");

        lblMarca.setText("Marca:");

        lblExistencia.setText("Existencia:");

        lblModelo.setText("Modelo:");

        lblTipo.setText("Tipo:");

        lblTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblTitulo.setText("Gestor de Inventario");

        cbox_Ano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));

        cbox_Marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Acura", "Audi", "BMW", "Buick", "Cadillac", "Chevrolet", "Chrysler", "Dodge", "Fiat", "Ford", "GMC", "Honda", "Hyundai", "Isuzu", "Jeep", "Kia", "Lexus", "Lincoln", "Mazda", "Mercedes-Benz", "Mitsubishi", "Nissan", "Peugeot", "Porsche", "Ram", "Renault", "Seat", "Skoda", "Subaru", "Suzuki", "Tata", "Toyota", "Volkswagen", "Volvo" }));
        cbox_Marca.setToolTipText("");

        lblAno.setText("Ano:");

        cbox_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Sedan", "Camioneta", "Pickup", "Microbus", "Van / miniVan", "Hatchback", "Coupe" }));
        cbox_Tipo.setToolTipText("");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir))
                    .addComponent(cbox_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblModelo)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblTipo)
                                    .addGap(141, 141, 141))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbox_Marca, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblMarca))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAno)
                            .addComponent(lblExistencia)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbox_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(75, 75, 75)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitulo)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbox_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbox_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblExistencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbox_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        String marca = cbox_Marca.getSelectedItem().toString();
        String modelo = txtModelo.getText().trim();
        String tipo = cbox_Tipo.getSelectedItem().toString();
        String anoTexto = cbox_Ano.getSelectedItem().toString();
        String stockTexto = txtStock.getText().trim();

        if (marca.isEmpty() || modelo.isEmpty() || tipo.isEmpty() || anoTexto.isEmpty() || stockTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Todos los campos deben estar llenos.");
            return;
        }

        try {
            int ano = Integer.parseInt(anoTexto);
            int existencia = Integer.parseInt(stockTexto);

            // Configurar los datos en el DAO
            inventarioDAO.setMarca(marca);
            inventarioDAO.setModelo(modelo);
            inventarioDAO.setTipo(tipo);
            inventarioDAO.setAno(ano);
            inventarioDAO.setExistencia(existencia);

            // Llamar a la lógica para actualizar el inventario
            boolean resultado = inventarioLogica.actualizarInventario(inventarioDAO);
            if (resultado) {
                JOptionPane.showMessageDialog(this, "Error al actualizar los datos del inventario.");
            } else {
                frameInventario.actualizarTablaInventario();
                JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.");               
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Año y Existencia deben ser números.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        String modelo = txtModelo.getText().trim();

        if (modelo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: El campo Modelo debe estar lleno.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Estás seguro de que deseas eliminar este registro?", 
            "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean resultado = inventarioLogica.eliminarInventario(modelo);
            if (resultado) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el registro.");
            } else {
                frameInventario.actualizarTablaInventario();
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente.");
                limpiarCampos();
            }
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbox_Ano;
    private javax.swing.JComboBox<String> cbox_Marca;
    private javax.swing.JComboBox<String> cbox_Tipo;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblExistencia;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}