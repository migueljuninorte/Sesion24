package modelo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Empleado {
              
    protected long id ;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected String celular;
    protected Boolean esProveedor;
    protected String salario;
    protected String cargo;
    protected Boolean activo;
    
    public Empleado(long id, String nombre, String apellido, String correo, String celular, Boolean esProveedor, String salario, String cargo, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.esProveedor = esProveedor;
        this.salario = salario;
        this.cargo = cargo;
        this.activo = activo;
    }
    
    public Empleado( String nombre, String apellido, String correo, String celular, Boolean esProveedor, String salario, String cargo, Boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.esProveedor = esProveedor;
        this.salario = salario;
        this.cargo = cargo;
        this.activo = activo;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public Boolean getEsProveedor(){
        return esProveedor;
    }
    
    public void setEsProveedor(Boolean esProveedor){
        this.esProveedor = esProveedor;
    }
    
    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public Boolean getActivo(){
        return activo;
    }
    
    public void setActivo(Boolean activo){
        this.activo = activo;
    }

    public void crear() {
        try {
            Conexion conexion = new Conexion("mydb.db");
            conexion.conectar();

            Statement stmt = conexion.getConexion().createStatement();
            stmt.execute("insert into empleados (nombre,apellido,correo,celular,esProveedor,salario,cargo, activo) "
                    + "values ('" + this.nombre + "','" + this.apellido + "','" + this.correo + "','" + this.celular + "'," + (this.esProveedor ? 1 : 0) + ","
                    + "'" + this.salario + "','" + this.cargo + "','" + (this.activo ? 1 : 0) + "');");
            //ResultSet result = stmt.executeQuery("SELECT * FROM db_test.usuarios");
            stmt.close();
            conexion.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Empleado leerEmpleado(long identificador) {

        Empleado empleado = null;

        try {
            Conexion conexion = new Conexion("mydb.db");
            conexion.conectar();

            Statement stmt = conexion.getConexion().createStatement();
            ResultSet result = stmt.executeQuery("select * from empleados where id= " + identificador);
            while (result.next()) {
                long id = result.getInt("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String correo = result.getString("correo");
                String celular = result.getString("celular");
                Boolean esProveedor = result.getBoolean("esProveedor");
                String salario = result.getString("salario");
                String cargo = result.getString("cargo");
                Boolean activo = result.getBoolean("activo");

                empleado = new Empleado(id, nombre, apellido, correo, celular, esProveedor, salario, cargo, activo);
            }
            result.close();

            conexion.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return empleado;
    }

    public static void actualizar(long id, String nombre, String apellido, String correo, String celular, Boolean esProveedor, String salario, String cargo, Boolean activo) {
        try {
            Conexion conexion = new Conexion("mydb.db");
            conexion.conectar();

            Statement stmt = conexion.getConexion().createStatement();
            stmt.execute("update empleados set nombre='" + nombre + "',apellido='" + apellido + "',"
                    + "correo='" + correo + "',celular='" + celular + "',esProveedor=" + (esProveedor ? 1 : 0) + ", "
                    + "salario='" + salario + "',cargo='" + cargo + "',activo=" + (activo ? 1 : 0) 
                    + " where id=" + id + ";");
            //ResultSet result = stmt.executeQuery("SELECT * FROM db_test.usuarios");
            stmt.close();

            conexion.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void borrar(Long id) {
        try {
            Conexion conexion = new Conexion("mydb.db");
            conexion.conectar();

            Statement stmt = conexion.getConexion().createStatement();
            stmt.execute("delete from empleados where id=" + id + ";");
            //ResultSet result = stmt.executeQuery("SELECT * FROM db_test.usuarios");
            stmt.close();

            conexion.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

