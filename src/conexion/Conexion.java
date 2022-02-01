package conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {
    private static Conexion conex = new Conexion();
    private EntityManagerFactory factory;
    
    private Conexion(){
        factory = Persistence.createEntityManagerFactory("controlDePersonasPU");
    }

    public static Conexion getConex() {
        return conex;
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }
    
    
}
