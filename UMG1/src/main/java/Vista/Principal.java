/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

//Maestros
import Controlador.Maestros;
import Modelo.MaestrosDAO;
//Jornadas
import Controlador.Jornadas;
import Modelo.JornadasDAO;
import java.util.List;


/**
 *
 * @author Angel R
 */
public class Principal {
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
 
//*INSERT*
Maestros maestros = new Maestros(10, "Ing. Francisco", "Zona 18", "Activo");// Crear un objeto Maestros con datos específicos
System.out.println(maestros.toString()); // Imprimir el objeto Maestros

// Crear un objeto MaestrosDAO para interactuar con la base de datos
MaestrosDAO maestrosdao = new MaestrosDAO();
// Insertar el objeto Maestros en la base de datos
maestrosdao.insert(maestros);

// Crear un objeto Maestros para buscar un registro en la base de datos
Maestros maestros1 = new Maestros();
MaestrosDAO maestrosdao1 = new MaestrosDAO();
// Establecer el código del maestro a buscar
maestros1.setMAE_Código(87);
// Buscar el registro en la base de datos
maestros1 = maestrosdao1.query(maestros1);
System.out.println(maestros1.toString()); // Imprimir el resultado de la búsqueda

// Crear un objeto Maestros para actualizar un registro en la base de datos
Maestros maestros2 = new Maestros(87, "Florian", "Zona 18", "Activo");
MaestrosDAO maestrosdao2 = new MaestrosDAO();
// Actualizar el registro en la base de datos
maestrosdao2.update(maestros2);
System.out.println(maestros2.toString()); // Imprimir el objeto Maestros actualizado

// Crear un objeto Maestros para eliminar un registro en la base de datos
Maestros maestros3 = new Maestros(10);
MaestrosDAO maestrosdao3 = new MaestrosDAO();
// Eliminar el registro en la base de datos
maestrosdao3.delete(maestros3);
System.out.println("Registro eliminado"); // Imprimir mensaje de confirmación

// Crear un objeto MaestrosDAO para obtener todos los registros de la base de datos
Maestros maestros4 = new Maestros();
MaestrosDAO maestrosdao4 = new MaestrosDAO();
// Obtener todos los registros de la base de datos
List<Maestros> maestross = maestrosdao4.select();
// Imprimir todos los registros
for (Maestros lista : maestross) {
    System.out.println(lista.toString());
}
 
//----------------------------CRUD PARA Jornadas----------------
//*INSERT*
       
       Jornadas jornadas = new Jornadas(2,"Vespertina");
       JornadasDAO jornadasdao = new JornadasDAO();
       jornadasdao.insert(jornadas);
       
       //*QUERY*
       Jornadas jornadas1= new Jornadas();
       JornadasDAO jornadasdao1 = new JornadasDAO();
       jornadasdao1.query(jornadas1);
       jornadas1.setJOR_Código(2);
       jornadas1=jornadasdao1.query(jornadas1);
       System.out.println(jornadas1.toString());
       
       //*UPDATE*
       Jornadas jornadas2 = new Jornadas(1,"Matutina");
       JornadasDAO jornadasdao2 = new JornadasDAO();
       jornadasdao2.update(jornadas2);
       System.out.println(jornadas2.toString());
       
       //*DELETE*
       Jornadas jornadas3= new Jornadas(2);
       JornadasDAO jornadasdao3= new JornadasDAO();
       jornadasdao3.delete(jornadas3);
       System.out.println(jornadas3.toString());
        
       //*SELECT*
       Jornadas jornadas4 = new Jornadas();
       JornadasDAO jornadasdao4 = new JornadasDAO();
       List<Jornadas> jornadass = jornadasdao4.select();
       for (Jornadas lista : jornadass) {
       System.out.println(lista.toString());    
}
}
     }

