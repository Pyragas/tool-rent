package com.psk.pyragas.ToolRent.test;
import com.psk.pyragas.ToolRent.dao.*;
import com.psk.pyragas.ToolRent.entities.*;
import com.psk.pyragas.ToolRent.persistence.Resources;
import org.junit.Test;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

public class TestPersistence {

    Logger testLog = Logger.getLogger(this.getClass().getName());

    @Test
    public void entityPersistence() {
        testLog.info("----Persistence test started----");

        StupidSimpleUsersDAO userDAO = new StupidSimpleUsersDAO();
        StupidSimpleProfilesDAO profileDAO = new StupidSimpleProfilesDAO();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ToolRentPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            userDAO.setEm(em);
            profileDAO.setEm(em);
            User johnUser = new User();
            Profile johnProfile = new Profile();
            johnUser.setId(1L);
            johnProfile.setId(1L);
            johnProfile.setName("John");
            johnProfile.setSurname("Hamburg");
            userDAO.persist(johnUser);
            profileDAO.persist(johnProfile);
            em.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("User Entity Persistence error: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            em.close();
            emf.close();
        }
    }
}