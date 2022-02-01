package controlador;

import conexion.Conexion;
import entidades.Persona;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ControladorPersona {
    private EntityManager entityManager(){
        return Conexion.getConex().getFactory().createEntityManager();
    }
    
    public void guardarPersona(Persona p1){
        EntityManager em = entityManager();
        try{
            em.getTransaction().begin();
            em.persist(p1);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println("La transaccion no pudo realizarse");
            em.getTransaction().rollback();
        }
    }
    
    public void eliminarPersona(Persona p1){
        EntityManager em = entityManager();
        try{
            em.getTransaction().begin();
            em.remove(em.merge(p1));
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println("No pudo eliminarse la persona");
            em.getTransaction().rollback();
        }
    }
    
    public void editarPersona(Persona p1){
        EntityManager em = entityManager();
        try{
            em.getTransaction().begin();
            em.merge(p1);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println("No pudo realizarse el edit");
            em.getTransaction().rollback();
        }
    }
    
    public List<Persona> listadoPersonas(){
        Query q = entityManager().createQuery("SELECT p FROM Persona p");
        return q.getResultList();
    }
    
    public void mostrarPersonas(List<Persona> listadoPersonas){
        for(Persona p1: listadoPersonas){
            System.out.println(p1);
        }
    }
    
    public Persona crearPersona(){
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese nombre de la persona: ");
        String nombre = scan.nextLine();
        System.out.println("Ingrese apellido: ");
        String apellido = scan.nextLine();
        System.out.println("Ingrese dni: ");
        String dni = scan.nextLine();
        System.out.println("Ingrese telefono: ");
        String tel = scan.nextLine();
        System.out.println("Ingrese direccion: ");
        String direccion = scan.nextLine();
        return new Persona(null, nombre, apellido, dni, tel, direccion);   
    }
    
    public Persona buscarPorId(int id){
        List<Persona> listadoPersonas = listadoPersonas();
        Iterator it = listadoPersonas.iterator();
        while(it.hasNext()){
            Persona p1 = (Persona)it.next();
            if(p1.getIdpersona() == id){
                return p1;
            }
        }
        return null;
    }
    
    public Persona modificarPersona(Persona p1){
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese nombre de la persona: ");
        p1.setNombre(scan.nextLine());
        System.out.println("Ingrese apellido: ");
        p1.setApellido(scan.nextLine());
        System.out.println("Ingrese dni: ");
        p1.setDni(scan.nextLine());
        System.out.println("Ingrese telefono: ");
        p1.setTelefono(scan.nextLine());
        System.out.println("Ingrese direccion: ");
        p1.setDireccion(scan.nextLine());
        return p1;
    }
}
