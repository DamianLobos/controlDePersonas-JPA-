package controldepersonas;

import controlador.ControladorPersona;
import entidades.Persona;
import java.util.List;
import java.util.Scanner;

public class ControlDePersonas {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        ControladorPersona cPersona = new ControladorPersona();
        int op = 0;
        Persona p1;
        int id;
        do{
            System.out.println("Seleccione una opcion: ");
            System.out.println("1_Guardar persona");
            System.out.println("2_Editar persona");
            System.out.println("3_Eliminar persona");
            System.out.println("4_Mostrar personas");
            System.out.println("5_Salir");
            op = scan.nextInt();
            switch(op){
                case 1: 
                    p1 = cPersona.crearPersona();
                    cPersona.guardarPersona(p1);
                    break;
                case 2:
                    System.out.println("Ingrese id de la persona a modificar: ");
                    id = scan.nextInt();
                    p1 = cPersona.buscarPorId(id);
                    if(p1 != null){
                        p1 = cPersona.modificarPersona(p1);
                        cPersona.editarPersona(p1);
                    }else{
                        System.out.println("No se encontro el id buscado");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese id de la persona a eliminar: ");
                    id = scan.nextInt();
                    p1 = cPersona.buscarPorId(id);
                    if(p1 != null){
                        cPersona.eliminarPersona(p1);
                    }else{
                        System.out.println("No se encontro el id buscado");
                    }
                    break;
                case 4:
                    List<Persona> listado = cPersona.listadoPersonas();
                    cPersona.mostrarPersonas(listado);
                    break;
                case 5:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion inexistente");
                    break;
                    
            }
        }while(op != 5);
    }
    
}
