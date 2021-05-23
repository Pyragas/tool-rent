package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.Profile;
import lombok.SneakyThrows;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProfilesDAO {

    @Inject
    private EntityManager em;

    public void persist(Profile profile) { em.persist(profile); }

    public Profile findOne(Long id) {
        return em.find(Profile.class, id);
    }


    @Transactional
    public Profile update(Profile profile) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Profile profile1 = em.merge(profile);
        System.out.println("after merge");
        System.out.println("after context update");
        return profile1;
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
