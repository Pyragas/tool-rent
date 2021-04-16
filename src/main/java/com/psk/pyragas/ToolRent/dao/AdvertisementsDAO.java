package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.Advertisement;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class AdvertisementsDAO {
    @Inject
    private EntityManager em;

    public void persist(Advertisement ad) {
        this.em.persist(ad);
    }

    public Advertisement findOne(Long id) {
        return this.em.find(Advertisement.class, id);
    }

    public Advertisement update(Advertisement ad) {
        return this.em.merge(ad);
    }

    public List<Advertisement> loadAll() {
        return this.em.createNamedQuery("Advertisement.findAll", Advertisement.class).getResultList();
    }
}