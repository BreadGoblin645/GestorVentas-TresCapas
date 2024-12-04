
package CapaLogica;
import CapaControlador.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexhp
 */

public class UsuariosLogica {
    Conexion conexion;
    
    public UsuariosLogica(){
        conexion = new Conexion();
    }
    
    // INSERTAR USUARIOS
    public boolean insertarUsuario(UsuariosDAO pUsuarioDAO){
        String consultaSQL = "";
        consultaSQL = "INSERT INTO Usuarios(correos, nombres, apellidos, claves, niveles) ";
        consultaSQL += "VALUES('" + pUsuarioDAO.getCorreos() + "', '" + pUsuarioDAO.getNombres() + "', '" + pUsuarioDAO.getApellidos() + "', '" + pUsuarioDAO.getClaves() + "', '" + pUsuarioDAO.getNivel() + "')";
        
        try{
            return conexion.ejecutaSentenciasAccion(consultaSQL);
        } catch (Exception e) {
            System.out.println("Error: INSERTAR USUARIO" + e.getMessage());
            return true;
        }
    }
    
    // OBTIENE LA INFORMACION DE LOS USUARIOS DE LA BASE DE DATOS
    public ArrayList<UsuariosDAO> getListado(UsuariosDAO pUsuariosDAO){
        String correo = pUsuariosDAO.getCorreos();
        ArrayList<UsuariosDAO> listadoRetornar = new ArrayList<>();
        String consultaSQL = "";
        try {
            consultaSQL = "SELECT * FROM usuarios ";
            if(!correo.equals("-1")){
                consultaSQL += "WHERE correos = '" + correo + "'";
            }
            
            ResultSet resultado = conexion.ejecutaSentenciasSelect(consultaSQL);
            
            while(resultado.next()){
                UsuariosDAO objUsuariosDAO = new UsuariosDAO();
                
                objUsuariosDAO.setCorreos(resultado.getString("correos"));
                objUsuariosDAO.setNombres(resultado.getString(2));
                objUsuariosDAO.setApellidos(resultado.getString(3));
                objUsuariosDAO.setClaves(resultado.getString(4));
                objUsuariosDAO.setNivel(resultado.getInt(5));
                
                listadoRetornar.add(objUsuariosDAO);
            }
        } catch (SQLException e) {
            System.out.println("ERROR en getListado: " + e.getMessage());
        }
        return listadoRetornar;
    }
    
    // ACTUALIZA LOS DATOS DEL USUARIO
    public boolean actualizarUsuario(UsuariosDAO pUsuarioDAO) {
        
        String consultaSQL = "UPDATE usuarios SET nombres = '" + pUsuarioDAO.getNombres() + "', " +
                             "apellidos = '" + pUsuarioDAO.getApellidos() + "', " +
                             "claves = '" + pUsuarioDAO.getClaves() + "', " +
                             "niveles = " + pUsuarioDAO.getNivel() +
                             " WHERE correos = '" + pUsuarioDAO.getCorreos() + "'";

        try {
            return conexion.ejecutaSentenciasAccion(consultaSQL);
        } catch (Exception e) {
            System.out.println("ERROR al actualizar el usuario: " + e.getMessage());
            return true;
        }
    }
    
    //ELIMINAR LOS DATOS DEL USUARIO
    public boolean eliminarUsuario(String correo) {
        String consultaSQL = "DELETE FROM usuarios WHERE correos = '" + correo + "'";

        try {
            return conexion.ejecutaSentenciasAccion(consultaSQL);
        } catch (Exception e) {
            System.out.println("ERROR al eliminar el usuario: " + e.getMessage());
            return true;
        }
    }    
    
    // OBTIENE LOS DATOS DE LA TABLA USUARIOS PARA AGREGARLOS A LA JTABLE
    public ResultSet obtenerTodosLosUsuarios() {
        String consultaSQL = "SELECT * FROM usuarios";
        return conexion.ejecutaSentenciasSelect(consultaSQL);
    }

    // Validar correo y Clave con base de datos
    public boolean validarCredenciales(String correo, String clave) {      
        String consultaSQL = "SELECT * FROM usuarios WHERE correos = '" + correo + "' AND claves = '" + clave + "'";

        try {
            ResultSet resultado = conexion.ejecutaSentenciasSelect(consultaSQL);
            return resultado.next();
        } catch (Exception e) {
            System.out.println("Error al validar credenciales: " + e.getMessage());
            return false;
        }
    }
    
    // Obtener nombre y nivel por correo
    public UsuariosDAO obtenerDatosUsuario(String correo) {
        String consultaSQL = "SELECT nombres, niveles FROM usuarios WHERE correos = '" + correo + "'";
        UsuariosDAO usuario = null;

        try {
            ResultSet resultado = conexion.ejecutaSentenciasSelect(consultaSQL);
            if (resultado.next()) {
                usuario = new UsuariosDAO();
                usuario.setNombres(resultado.getString("nombres"));
                usuario.setNivel(resultado.getInt("niveles"));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener datos del usuario: " + e.getMessage());
        }

        return usuario; // Retorna un objeto UsuariosDAO con los datos del usuario
    }

}
