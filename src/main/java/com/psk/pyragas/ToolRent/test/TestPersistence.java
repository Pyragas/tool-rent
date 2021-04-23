package com.psk.pyragas.ToolRent.test;
import com.psk.pyragas.ToolRent.dao.*;
import com.psk.pyragas.ToolRent.entities.*;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
@ApplicationScoped
@Getter @Setter
public class TestPersistence {

    @Inject
    UsersDAO userDAO;
    @Inject
    ProfilesDAO profileDAO;

    @Transactional
    public void entityPersistence() {
        User johnUser = new User();
        Profile johnProfile = new Profile();
        johnProfile.setName("John");
        johnProfile.setSurname("Hamburg");
        johnUser.setProfile(johnProfile);
        userDAO.persist(johnUser);
        profileDAO.persist(johnProfile);
    }
}