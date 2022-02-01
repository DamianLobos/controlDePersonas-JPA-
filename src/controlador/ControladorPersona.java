package controlador;

import conexion.Conexion;
import entidades.Persona;
import javax.persistence.EntityManager;

public class ControladorPersona {
    private EntityManager entityManager(){
        return Conexion.getConex().getFactory().createEntityManager();
    }
    
    public void crearPersona(Persona p1){
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
}
