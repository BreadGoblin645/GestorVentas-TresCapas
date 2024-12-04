
package CapaLogica;

/**
 *
 * @author alexhp
 */

import CapaControlador.Conexion;
import java.sql.ResultSet;

public class ClientesLogica {
    private Conexion conexion;

    public ClientesLogica() {
        this.conexion = new Conexion();
    }

    // Obtener todos los clientes
    public ResultSet obtenerClientes() {
        String consultaSQL = "SELECT * FROM clientes";
        return conexion.ejecutaSentenciasSelect(consultaSQL);
    }

    // Insertar nuevo cliente
    public boolean insertarCliente(ClientesDAO cliente) {
        String consultaSQL = "INSERT INTO clientes (nombre, apellido, correo, telefono) VALUES ('" +
                cliente.getNombre() + "', '" +
                cliente.getApellido() + "', '" +
                cliente.getCorreo() + "', '" +
                cliente.getTelefono() + "')";
        try {
            return conexion.ejecutaSentenciasAccion(consultaSQL);
        } catch (Exception e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
            return false;
        }
    }

    // Actualizar cliente existente
    public boolean actualizarCliente(ClientesDAO cliente) {
        String consultaSQL = "UPDATE clientes SET " +
                "nombre = '" + cliente.getNombre() + "', " +
                "apellido = '" + cliente.getApellido() + "', " +
                "correo = '" + cliente.getCorreo() + "', " +
                "telefono = '" + cliente.getTelefono() + "' " +
                "WHERE id = " + cliente.getId();
        try {
            return conexion.ejecutaSentenciasAccion(consultaSQL);
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    // Eliminar cliente
    public boolean eliminarCliente(int id) {
        String consultaSQL = "DELETE FROM clientes WHERE id = " + id;
        try {
            return conexion.ejecutaSentenciasAccion(consultaSQL);
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }

    // Buscar cliente por nombre o apellido
    public ResultSet buscarCliente(String criterio) {
        String consultaSQL = "SELECT * FROM clientes WHERE nombre LIKE '%" + criterio + 
                "%' OR apellido LIKE '%" + criterio + "%'";
        return conexion.ejecutaSentenciasSelect(consultaSQL);
    }
}
