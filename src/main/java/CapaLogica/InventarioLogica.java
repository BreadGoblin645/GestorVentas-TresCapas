
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
    
    public boolean eliminarInventarioPorId(int idInventario) {
        String consultaSQL = "DELETE FROM inventario WHERE id = " + idInventario;
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
    
    // Busqueda de Inventario por ID
    public ResultSet obtenerInventarioPorId(int id) {
        String consultaSQL = "SELECT * FROM inventario WHERE id = " + id;
        return conexion.ejecutaSentenciasSelect(consultaSQL);
    }  
    
    // Buscar marca de vehiculos en inventario
    public ResultSet obtenerMarcas() {
        String consultaSQL = "SELECT DISTINCT marca FROM inventario";
        return conexion.ejecutaSentenciasSelect(consultaSQL);
    }

    // BUSCAR MODELOS DE VEHICULOS SEGUN LA MARCA
    public ResultSet obtenerModelosPorMarca(String marca) {
        String consultaSQL = "SELECT DISTINCT modelo FROM inventario WHERE marca = '" + marca + "'";
        return conexion.ejecutaSentenciasSelect(consultaSQL);
    }
    
    // BUSCAR MODELOS DE VEHICULOS SEGUN EL MODELO Y LA MARCA
    public ResultSet obtenerAnosPorModelo(String marca, String modelo) {
        String consultaSQL = "SELECT DISTINCT ano FROM inventario WHERE marca = '" + marca + "' AND modelo = '" + modelo + "'";
        return conexion.ejecutaSentenciasSelect(consultaSQL);
    }
    
    public ResultSet obtenerIdInventario(String marca, String modelo, int ano) {
        String consultaSQL = "SELECT id FROM inventario WHERE marca = '" + marca + "' AND modelo = '" + modelo + "' AND ano = " + ano;
        return conexion.ejecutaSentenciasSelect(consultaSQL);
    }
    
}
