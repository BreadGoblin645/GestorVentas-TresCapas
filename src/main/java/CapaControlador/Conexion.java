
package CapaControlador;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author alexhp
 */
public class Conexion {
    
    private Connection conexion;
    private Statement ejecutaSentencias;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sistemas", "root", "");
            ejecutaSentencias = conexion.createStatement();
            System.out.println("SE CONECTO A LA BASE DE DATOS...");
        } catch (Exception e) {
            System.out.println("NO SE CONECTO A LA BASE DE DATOS: ERROR:" + e.getMessage());
        }
    }
    
    public boolean ejecutaSentenciasAccion(String consultaSQL){
        try {
            return ejecutaSentencias.execute(consultaSQL);           
        } catch (Exception e) {
            System.out.println("ERROR: en sentencia ejecutaSentenciasAccion" + e.getMessage());
            return true;
        }       
    }
    
    public ResultSet ejecutaSentenciasSelect(String consulraSQL) {
        ResultSet listado = null;
        try{
            listado = ejecutaSentencias.executeQuery(consulraSQL);
        } catch (Exception e) {
            System.out.println("ERROR: ejecutaSentenciasSelect: " + e.getMessage());
        }
        return listado;
    }    
}
