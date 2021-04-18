package com.psk.pyragas.ToolRent.test;

import com.psk.pyragas.ToolRent.dao.*;
import com.psk.pyragas.ToolRent.entities.*;

public class PersistenceTest {
    public static void main (String[] args) {
        UsersDAO userDAO = new UsersDAO();
        ProfilesDAO profileDAO = new ProfilesDAO();
        try {
            User johnUser = new User();
            Profile johnProfile = new Profile();
            johnUser.setId(12L);
            johnProfile.setId(12L);
            johnProfile.setName("John");
            johnProfile.setSurname("Hamburg");
            userDAO.persist(johnUser);
            profileDAO.persist(johnProfile);
            userDAO.commit();
            profileDAO.commit();
        }
        catch (Exception e){
            System.out.println("User persistence error: " + e.getMessage());
        }
    }
}