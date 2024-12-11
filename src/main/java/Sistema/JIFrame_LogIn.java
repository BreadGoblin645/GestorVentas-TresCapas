
package Sistema;
import CapaLogica.UsuariosLogica;
import CapaLogica.UsuariosDAO;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author alexhp
 */
public class JIFrame_LogIn extends javax.swing.JInternalFrame {
    
    private JDesktopPane desktopPane;
    private UsuariosLogica usuariosLogica;
    private MainFrame mainFrame;

    public JIFrame_LogIn(JDesktopPane desktopPane, MainFrame mainFrame) {
        initComponents();
        this.desktopPane = desktopPane; 
        this.mainFrame = mainFrame;
        usuariosLogica = new UsuariosLogica(); 
    }
    
    public void LimpiarCampos(){
        txtCorreo.setText("");
        txtClave.setText("");
        txtCorreo.requestFocus();  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCorreo = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        lblClave = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblCorreo = new javax.swing.JLabel();
        lblUserImag = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Iniciar Sesion");
        setToolTipText("");

        lblClave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblClave.setText("Clave");

        btnEntrar.setText("Log In");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        btnSalir.setText("EXIT");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblCorreo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCorreo.setText("Correo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCorreo)
                    .addComponent(lblClave))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEntrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClave)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrar)
                    .addComponent(btnSalir))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        lblUserImag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/blue-user.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserImag)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblUserImag))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

        String correo = txtCorreo.getText().trim();
        String clave = txtClave.getText().trim();
        int nivel = -1;

        if (correo.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Todos los campos deben estar llenos.");
            return;
        }

        if (usuariosLogica.validarCredenciales(correo, clave)) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso.");

            // Obtener nombre y nivel del usuario
            UsuariosDAO usuario = usuariosLogica.obtenerDatosUsuario(correo);
            if (usuario != null) {
                
                String nombre = usuario.getNombres();
                String apellido = usuario.getApellidos();
                nivel = usuario.getNivel();          

                String nivelTexto = switch (nivel) {
                    case 1 -> "Usuario";
                    case 2 -> "Asistente";
                    case 3 -> "Administrador";
                    default -> "Desconocido";
                };

                // Actualiza los labels del MainFrame y del panel de informacion del usuario
                mainFrame.actualizarLabelsUsuario(nombre, apellido, nivelTexto);
                mainFrame.ActualizarEstadoLogin(true, nivel);
                mainFrame.activarBotonCerrarSesision();
                mainFrame.desacativarLogInBoton();
            }
            
            this.dispose(); // Cerramos la ventana de LogIn
        } else {
            JOptionPane.showMessageDialog(this, "Error: Correo o clave inválidos.");
            LimpiarCampos();
        }
        //Enviamos el tipo de usuario al sistma principal.
        mainFrame.setNivelUsuario(nivel);
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblUserImag;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
