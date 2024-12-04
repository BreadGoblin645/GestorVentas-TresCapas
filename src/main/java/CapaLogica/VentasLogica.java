
package CapaLogica;

import CapaControlador.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author alexhp
 */

public class VentasLogica {
    
    private Conexion conexion;

    public VentasLogica() {
        this.conexion = new Conexion();
    }

    // Obtener todas las ventas
    public ResultSet obtenerVentas() {
        String consultaSQL = "SELECT * FROM ventas";
        return conexion.ejecutaSentenciasSelect(consultaSQL);
    }

    // Insertar una nueva venta
    public boolean insertarVenta(VentasDAO venta) {
        String consultaSQL = "INSERT INTO ventas (id_cliente, id_inventario, cantidad, total, fecha) VALUES (" +
                venta.getIdCliente() + ", " +
                venta.getIdInventario() + ", " +
                venta.getCantidad() + ", " +
                venta.getTotal() + ", '" +
                venta.getFecha() + "')";
        try {
            return conexion.ejecutaSentenciasAccion(consultaSQL);
        } catch (Exception e) {
            System.out.println("Error al insertar venta: " + e.getMessage());
            return false;
        }
    }

    // Actualizar una venta existente
    public boolean actualizarVenta(VentasDAO venta) {
        String consultaSQL = "UPDATE ventas SET " +
                "id_cliente = " + venta.getIdCliente() + ", " +
                "id_inventario = " + venta.getIdInventario() + ", " +
                "cantidad = " + venta.getCantidad() + ", " +
                "total = " + venta.getTotal() + ", " +
                "fecha = '" + venta.getFecha() + "' " +
                "WHERE id = " + venta.getId();
        try {
            return conexion.ejecutaSentenciasAccion(consultaSQL);
        } catch (Exception e) {
            System.out.println("Error al actualizar venta: " + e.getMessage());
            return false;
        }
    }

    // Eliminar una venta
    public boolean eliminarVenta(int id) {
        String consultaSQL = "DELETE FROM ventas WHERE id = " + id;
        try {
            return conexion.ejecutaSentenciasAccion(consultaSQL);
        } catch (Exception e) {
            System.out.println("Error al eliminar venta: " + e.getMessage());
            return false;
        }
    }

    // Buscar por VentaID o ClienteID
    public ResultSet buscarPorVentaOClienteID(int id) {
        String consultaSQL = "SELECT * FROM ventas WHERE id = " + id + " OR id_cliente = " + id;
        return conexion.ejecutaSentenciasSelect(consultaSQL);
    }
    
}