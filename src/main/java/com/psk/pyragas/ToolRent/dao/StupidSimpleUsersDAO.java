package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class StupidSimpleUsersDAO {
    @Inject
    private EntityManager em;

    public void persist(User user) { this.em.persist(user); }

    public void commit() { this.commit(); }

    public User findOne(Long id) {
        return this.em.find(User.class, id);
    }

    public User update(User user) {
        return this.em.merge(user);
    }

    public List<User> loadAll() {
        return this.em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
