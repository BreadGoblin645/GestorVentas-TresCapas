
package CapaLogica;

import CapaControlador.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexhp
 */

public class InventarioLogica {
    
    Conexion conexion;
    
    public InventarioLogica(){
        conexion = new Conexion();
    }
    
    // OBTIENE LOS DATOS DE LA TABLA USUARIOS PARA AGREGARLOS A LA JTABLE
    public ResultSet obtenerInventario() {
        String consultaSQL = "SELECT * FROM Inventario";
        return conexion.ejecutaSentenciasSelect(consultaSQL);
    }
    
    // INSERTAR INVENTARIO
    public boolean insertarInventario(InventarioDAO vehiculo) {
        String consultaSQL = "INSERT INTO inventario (marca, modelo, tipo, ano, existencia) VALUES ('" 
            + vehiculo.getMarca() + "', '" 
            + vehiculo.getModelo() + "', '" 
            + vehiculo.getTipo() + "', "
            + vehiculo.getAno() + ", " 
            + vehiculo.getExistencia() + ")";
        try {
            System.out.println("Consulta SQL: " + consultaSQL); // Depurar consulta
            return conexion.ejecutaSentenciasAccion(consultaSQL);
        } catch (Exception e) {
            System.out.println("Error al insertar vehículo: " + e.getMessage());
            return false;
        }
    }
    
    // ACTUALIZAR DATOS DE LA TABLA INVENTARIO
    public boolean actualizarInventario(InventarioDAO vehiculo) {
        String consultaSQL = "UPDATE inventario SET " +
            "marca = '" + vehiculo.getMarca() + "', " +
            "modelo = '" + vehiculo.getModelo() + "', " +
            "tipo = '" + vehiculo.getTipo() + "', " +
            "ano = " + vehiculo.getAno() + ", " +
            "existencia = " + vehiculo.getExistencia() +
            " WHERE id = '" + vehiculo.getId() + "'";

        try {
            return conexion.ejecutaSentenciasAccion(consultaSQL);
        } catch (Exception e) {
            System.out.println("Error al actualizar inventario: " + e.getMessage());
            return false;
        }
    }
    
    // ELIMINAR DATOS DE LA TABLA INVENTARIOS
    public boolean eliminarInventario(String modelo) {
        String consultaSQL = "DELETE FROM inventario WHERE modelo = '" + modelo + "'";
        try {
            return conexion.ejecutaSentenciasAccion(consultaSQL);
        } catch (Exception e) {
            System.out.println("Error al eliminar inventario: " + e.getMessage());
            return false;
        }
    }
    
    // BUSQUEDA DE INVENTARIO - Segun Marca o Modelo
    public ResultSet buscarInventario(String criterio) {
        String consultaSQL = "SELECT * FROM inventario WHERE marca LIKE '%" + criterio + "%' OR modelo LIKE '%" + criterio + "%'";
        return conexion.ejecutaSentenciasSelect(consultaSQL);
    }
    
}
