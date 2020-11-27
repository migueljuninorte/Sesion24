/*
 Objetivos:
- Trabajar con MVC y mostrar el desarrollo de la aplicación

Partes del programa
1. Modificar en el modelo la clase Empleado, con tres métodos adicionales:
  - public static Empleado leerEmpleado(long id) 
    Realiza una consulta en la base de datos y retorna un objeto con el empleado que se está buscando. 
  - public static actualizar 
    Recibe como parámetro todos los valores a actualizar y realiza la actualización de la base de datos.
  - crear
    Reciba como parámetro los valores de un empleado (excepto id) y realice la inserción de estos datos en la base de datos.

2. Crear un JFrame CrearEmpleadoFrame con los datos del Empleado (excepto id) para ser almacenados y 
   un botón Guardar que almacene la información en la base de datos. 

3. Crear un JFrame ModificarEmpleadoFrame que muestre los campos del Empleado (excepto id) modificables, obtenidos de la
    fila seleccionada en la tabla de RegistroEmpleadosFrame
   Adicionar el id del Empleado al título de la ventana y un botón Guardar que almacene la información en la base de datos. 
   Después de Guardar debe mostrar el mensaje en un JOptionPane “Datos del empleado actualizados” 
   si el empleado fue guardado correctamente y debe cerrar la ventana, o “Error al guardar empleado” 
   si no se pudo guardar el empleado.

4. Modificar el Controlador para
    a. Crear las variables de los nuevos JFrame dentro del controlador
    b. Crear los metodos 
    - crearEmpleado
      Obtiene la informacion del CrearEmpleadoFrame, llama al modelo para crear el 
      empleado en la base de datos, cierra el frame de crearEmpleados y actualiza el JTable 
    - leerEmpleadoRegistroEmpleadosFrame
      Identifica el registro seleccionad en JTable, llama al metodo del modelo para 
       leer la informacion de ese id y lo muestra en un frame de ModificarEmpleadoFrame.
       Si no se ha seleccionado ningun empleado, retorna un JOptionPane "Debe seleccionar un empleado"
    - actualizar
       Obtiene la informacion del ModificarEmpleadoFrame y llama al modelo para actualizar la base de datos

5. Actualizar los nuevos JFrame para que cuando se presione el boton Guardar en cada uno llame 
    al metodo correspondiente en el Controlador.
 Objetivos:
- Trabajar con MVC y mostrar el desarrollo de la aplicación

Partes del programa
1. Modificar en el modelo la clase Empleado, con tres métodos adicionales:
  - public static Empleado leerEmpleado(long id) 
    Realiza una consulta en la base de datos y retorna un objeto con el empleado que se está buscando. 
  - public static actualizar 
    Recibe como parámetro todos los valores a actualizar y realiza la actualización de la base de datos.
  - crear
    Reciba como parámetro los valores de un empleado (excepto id) y realice la inserción de estos datos en la base de datos.

2. Crear un JFrame CrearEmpleadoFrame con los datos del Empleado (excepto id) para ser almacenados y 
   un botón Guardar que almacene la información en la base de datos. 

3. Crear un JFrame ModificarEmpleadoFrame que muestre los campos del Empleado (excepto id) modificables, obtenidos de la
    fila seleccionada en la tabla de RegistroEmpleadosFrame
   Adicionar el id del Empleado al título de la ventana y un botón Guardar que almacene la información en la base de datos. 
   Después de Guardar debe mostrar el mensaje en un JOptionPane “Datos del empleado actualizados” 
   si el empleado fue guardado correctamente y debe cerrar la ventana, o “Error al guardar empleado” 
   si no se pudo guardar el empleado.

4. Modificar el Controlador para
    a. Crear las variables de los nuevos JFrame dentro del controlador
    b. Crear los metodos 
    - crearEmpleado
      Obtiene la informacion del CrearEmpleadoFrame, llama al modelo para crear el 
      empleado en la base de datos, cierra el frame de crearEmpleados y actualiza el JTable 
    - leerEmpleadoRegistroEmpleadosFrame
      Identifica el registro seleccionad en JTable, llama al metodo del modelo para 
       leer la informacion de ese id y lo muestra en un frame de ModificarEmpleadoFrame.
       Si no se ha seleccionado ningun empleado, retorna un JOptionPane "Debe seleccionar un empleado"
    - actualizar
       Obtiene la informacion del ModificarEmpleadoFrame y llama al modelo para actualizar la base de datos

5. Actualizar los nuevos JFrame para que cuando se presione el boton Guardar en cada uno llame 
    al metodo correspondiente en el Controlador.
 */
package mvc;

import controlador.Controlador;
import vista.RegistroEmpleadosFrame;


public class MVC {
    
    public static void main(String [] args){
        RegistroEmpleadosFrame ref = new RegistroEmpleadosFrame();
        Controlador c = new Controlador(ref);
        c.iniciar();
        ref.setControlador(c);
        ref.setVisible(true);
    }
    
}
