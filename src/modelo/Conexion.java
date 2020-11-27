package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    private String url;
    private Connection conexion;

    public Conexion(String url) {
        this.url = url;
    }
    
    public void conectar(){
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            System.out.println("Conexion exitosa con la base de datos");
        } catch (SQLException e) {
            System.out.println("Error en conexion con la base de datos: " + e);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en conexion con la base de datos 2: " + ex);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    
    
}