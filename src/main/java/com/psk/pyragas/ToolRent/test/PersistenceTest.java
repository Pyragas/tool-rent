package com.psk.pyragas.ToolRent.test;

import com.psk.pyragas.ToolRent.dao.*;
import com.psk.pyragas.ToolRent.entities.*;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PersistenceTest {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
            userPersistenceTest(sessionFactory);
        }
    }

    public static void userPersistenceTest(SessionFactory sessionFactory){
        UsersDAO userDAO = new UsersDAO(sessionFactory, User.class);
        ProfilesDAO profileDAO = new ProfilesDAO(sessionFactory, Profile.class);
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            User johnUser = new User();
            Profile johnProfile = new Profile();
            johnUser.setId(12L);
            johnProfile.setId(12L);
            johnProfile.setName("John");
            johnProfile.setSurname("Hamburg");
            userDAO.save(johnUser);
            profileDAO.save(johnProfile);
            transaction.commit();
        }
        catch (Exception e){
            System.out.println("User persistence error: " + e.getMessage());
        }
    }
}