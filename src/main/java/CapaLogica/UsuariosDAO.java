
package CapaLogica;

/**
 *
 * @author alexhp
 */

public class UsuariosDAO {
    
    private String correos;
    private String nombres;
    private String apellidos;
    private String claves;
    private int nivel;

    public String getCorreos() {
        return correos;
    }

    public void setCorreos(String correos) {
        this.correos = correos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getClaves() {
        return claves;
    }

    public void setClaves(String claves) {
        this.claves = claves;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }  
}
