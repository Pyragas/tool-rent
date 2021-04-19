package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.Profile;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ProfilesDAO {
    @Inject
    private EntityManager em;

    public void persist(Profile profile) {
        this.em.persist(profile);
    }

    public Profile findOne(Long id) {
        return this.em.find(Profile.class, id);
    }

    public Profile update(Profile profile) {
        return this.em.merge(profile);
    }

    public List<Profile> loadAll() {
        return this.em.createNamedQuery("Profile.findAll", Profile.class).getResultList();
    }
}
