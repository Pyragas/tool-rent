package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class UsersDAO {
    @Inject
    private EntityManager em;

    public void persist(User user) { em.persist(user); }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    public User update(User user) {
        return em.merge(user);
    }

    public List<User> loadAll() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }
}