package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.Item;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ItemsDAO {
    @Inject
    private EntityManager em;

    public void persist(Item item) {
        this.em.persist(item);
    }

    public Item findOne(Long id) {
        return this.em.find(Item.class, id);
    }

    public Item update(Item item) {
        return this.em.merge(item);
    }

    public List<Item> loadAll() {
        return this.em.createNamedQuery("Item.findAll", Item.class).getResultList();
    }
}
