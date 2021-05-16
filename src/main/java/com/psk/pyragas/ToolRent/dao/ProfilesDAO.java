package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.Profile;
import com.psk.pyragas.ToolRent.interceptors.WillBeLogged;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@WillBeLogged
@ApplicationScoped
public class ProfilesDAO {
    @Inject
    private EntityManager em;

    public void persist(Profile profile) { em.persist(profile); }

    public Profile findOne(Long id) {
        return em.find(Profile.class, id);
    }

    public Profile update(Profile profile) {
        return em.merge(profile);
    }

    public List<Profile> loadAll() {
        return this.em.createNamedQuery("Profile.findAll", Profile.class).getResultList();
    }

    public Profile findOneByEmailAndPassword(String email, String password) {
        return this.em.createNamedQuery("Profile.findOneByEmailAndPassword", Profile.class)
                .setParameter("email", email)
                .setParameter("pass", password)
                .getSingleResult();
    }
}
