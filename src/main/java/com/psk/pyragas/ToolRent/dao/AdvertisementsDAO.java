package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.Advertisement;
import com.psk.pyragas.ToolRent.interceptors.WillBeLogged;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@WillBeLogged
@ApplicationScoped
public class AdvertisementsDAO {
    @Inject
    private EntityManager em;

    public void persist(Advertisement ad) {
        em.persist(ad);
    }

    public Advertisement findOne(Long id) {
        return em.find(Advertisement.class, id);
    }

    public Advertisement update(Advertisement ad) {
        return em.merge(ad);
    }

    public List<Advertisement> loadAll() {
        return em.createNamedQuery("Advertisement.findAll", Advertisement.class).getResultList();
    }

    public List<Advertisement> loadNumber(int number) {
        return em.createNamedQuery("Advertisement.findAll", Advertisement.class).setMaxResults(number).getResultList();
    }
}
