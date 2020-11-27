/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marce
 */
public class GestionarEmpleados {
    
    public final static String[] columnas = {"Id","Nombre","Apellido", "Correo", "Celular", "Proveedor", "Salario", "Cargo", "Activo"};
    
    public static ArrayList<Object[]> ConsultarEmpleados() {

        ArrayList<Object[]> empleados = new ArrayList();

        try {
            Conexion conexion = new Conexion("mydb.db");
            conexion.conectar();

            Statement stmt = conexion.getConexion().createStatement();
            ResultSet result = stmt.executeQuery("select * from empleados");
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
                
                Object[] empleado ={id, nombre, apellido, correo, celular, esProveedor, salario, cargo, activo};
                empleados.add(empleado);
            }
            result.close();

            conexion.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return empleados;
    }   
    
}
