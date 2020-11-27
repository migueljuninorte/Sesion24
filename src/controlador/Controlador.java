/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.GestionarEmpleados;
import vista.RegistroEmpleadosFrame;
import vista.CrearEmpleadoFrame;
import vista.ModificarEmpleadoFrame;


public class Controlador{
    
    private final RegistroEmpleadosFrame registroEmpleadosFrame;
    private static CrearEmpleadoFrame crearEmpleadoFrame;
    private static ModificarEmpleadoFrame modificarEmpleadoFrame;
    
    public Controlador(RegistroEmpleadosFrame registroEmpleadosFrame){
        this.registroEmpleadosFrame = registroEmpleadosFrame;
    }
    
    public void iniciar(){
        registroEmpleadosFrame.setTitle("Registro de Empleados");
        registroEmpleadosFrame.setLocationRelativeTo(null);
        listarEmpleadosFrame();
    }
    
    public void listarEmpleadosFrame(){
        DefaultTableModel modelo = new DefaultTableModel(GestionarEmpleados.columnas,0);
        ArrayList<Object[]> empleados = GestionarEmpleados.ConsultarEmpleados();
        for (Object[]empleado : empleados) {
            modelo.addRow(empleado);
        }
        System.out.println("Modelo adicionado a las base de datos");
        registroEmpleadosFrame.setTable(modelo);
    }

    
    public void setCrearEmpleadoFrame(CrearEmpleadoFrame crearEmpleadoFrame){
        this.crearEmpleadoFrame = crearEmpleadoFrame;
    }
    
    public void newCrearEmpleadoFrame(){
        this.crearEmpleadoFrame = new CrearEmpleadoFrame(this);
        crearEmpleadoFrame.setVisible(true);
    }
    
   
    public  void crearEmpleado(){
        Empleado e = new Empleado(crearEmpleadoFrame.getJTextField(1),crearEmpleadoFrame.getJTextField(2),
                                crearEmpleadoFrame.getJTextField(3), crearEmpleadoFrame.getJTextField(4), crearEmpleadoFrame.getJCheckBox(1),
                                crearEmpleadoFrame.getJTextField(5), crearEmpleadoFrame.getJTextField(6),crearEmpleadoFrame.getJCheckBox(2));
        e.crear();
        crearEmpleadoFrame.setVisible(false);
        listarEmpleadosFrame();
    }
    
    public  void actualizarEmpleado(){
        Empleado.actualizar(modificarEmpleadoFrame.getId(),modificarEmpleadoFrame.getJTextField(1),modificarEmpleadoFrame.getJTextField(2),
                                modificarEmpleadoFrame.getJTextField(3), modificarEmpleadoFrame.getJTextField(4), modificarEmpleadoFrame.getJCheckBox(1),
                                modificarEmpleadoFrame.getJTextField(5), modificarEmpleadoFrame.getJTextField(6),modificarEmpleadoFrame.getJCheckBox(2));
        modificarEmpleadoFrame.setVisible(false);
        listarEmpleadosFrame();
    }
    
    public void leerEmpleadoRegistroEmpleadosFrame(){
        DefaultTableModel modelo = registroEmpleadosFrame.getTableModel();
        int fila = registroEmpleadosFrame.getValorJTable();
        if(fila == -1){
            JOptionPane optionPane = new JOptionPane("Debe seleccionar un empleado", JOptionPane.ERROR_MESSAGE);    
            JDialog dialog = optionPane.createDialog("Error");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }else{
            System.out.println(modelo.getValueAt(fila, 0));
            long id = (long)modelo.getValueAt(fila,0);

            Empleado e = Empleado.leerEmpleado(id);

            modificarEmpleadoFrame = new ModificarEmpleadoFrame(this,id);

            modificarEmpleadoFrame.setJTextField(1, e.getNombre());
            modificarEmpleadoFrame.setJTextField(2, e.getApellido());
            modificarEmpleadoFrame.setJTextField(3, e.getCorreo());
            modificarEmpleadoFrame.setJTextField(4, e.getCelular());
            modificarEmpleadoFrame.setJTextField(5, e.getSalario());
            modificarEmpleadoFrame.setJTextField(6, e.getCargo());

            modificarEmpleadoFrame.setJCheckBox(1, e.getEsProveedor());
            modificarEmpleadoFrame.setJCheckBox(2, e.getActivo());

            modificarEmpleadoFrame.setVisible(true);
        }
    }
}
