package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.Photo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PhotosDAO {
    @Inject
    private EntityManager em;

    public void persist(Photo photo) {
        this.em.persist(photo);
    }

    public Photo findOne(Long id) {
        return this.em.find(Photo.class, id);
    }

    public Photo update(Photo photo) {
        return this.em.merge(photo);
    }

    public List<Photo> loadAll() {
        return this.em.createNamedQuery("Photo.findAll", Photo.class).getResultList();
    }
}
