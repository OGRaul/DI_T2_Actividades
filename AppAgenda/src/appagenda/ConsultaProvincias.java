package appagenda;

import entidades.Provincia;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ConsultaProvincias 
{

   
    public static void main(String[] args) 
    {
        Map<String,String> emfProperties = new HashMap<String,String>();
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("DI_AppAgendaPU",emfProperties);
        EntityManager em = emf.createEntityManager();
          
        //DELETE
        int codDel = 15;
        Provincia provinciaDel = em.find(Provincia.class, codDel);
        em.getTransaction().begin();
        if (provinciaDel != null)
        {
            em.remove(provinciaDel);
        }
        else
        {
            System.out.println("No hay ninguna provincia con ID=" + codDel);
        }
        em.getTransaction().commit();
        
        
        
        //Cerrar la conexion
        em.close();
        emf.close();
        try{
        DriverManager.getConnection("jdbc:derby:DBAgenda;shutdown=true");
        } catch (SQLException ex){/*Siempre salta este error*/}

    }
    
}
