package com.psk.pyragas.ToolRent.test;
import com.psk.pyragas.ToolRent.dao.*;
import com.psk.pyragas.ToolRent.entities.*;
import com.psk.pyragas.ToolRent.persistence.Resources;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.logging.Logger;

@Named
@ApplicationScoped
@Getter @Setter
public class TestPersistence {

    Logger testLog = Logger.getLogger(this.getClass().getName());

    @Inject
    UsersDAO userDAO;
    @Inject
    ProfilesDAO profileDAO;

    @Transactional
    public void entityPersistence() {
        testLog.info("----Persistence test started----");
        User johnUser = new User();
        Profile johnProfile = new Profile();
        johnProfile.setName("John");
        johnProfile.setSurname("Hamburg");
        johnUser.setProfile(johnProfile);
        userDAO.persist(johnUser);
        profileDAO.persist(johnProfile);

        System.out.println("EntityPersistence has been called.");
    }
}