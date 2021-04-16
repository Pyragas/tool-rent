package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.Chat;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ChatsDAO {
    @Inject
    private EntityManager em;

    public void persist(Chat chat) {
        this.em.persist(chat);
    }

    public Chat findOne(Long id) {
        return this.em.find(Chat.class, id);
    }

    public Chat update(Chat chat) {
        return this.em.merge(chat);
    }

    public List<Chat> loadAll() {
        return this.em.createNamedQuery("Chat.findAll", Chat.class).getResultList();
    }
}
