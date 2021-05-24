package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.Photo;
import com.psk.pyragas.ToolRent.interceptors.WillBeLogged;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@WillBeLogged
@ApplicationScoped
public class PhotosDAO {
    @Inject
    private EntityManager em;

    public void persist(Photo photo) { em.persist(photo); }

    public Photo findOne(Long id) { return em.find(Photo.class, id); }

    public Photo update(Photo photo) { return em.merge(photo); }

    public List<Photo> loadAll() { return em.createNamedQuery("Photo.findAll", Photo.class).getResultList(); }
}
