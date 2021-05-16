package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.Chat;
import com.psk.pyragas.ToolRent.interceptors.WillBeLogged;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@WillBeLogged
@ApplicationScoped
public class ChatsDAO {
    @Inject
    private EntityManager em;

    public void persist(Chat chat) {
        em.persist(chat);
    }

    public Chat findOne(Long id) {
        return em.find(Chat.class, id);
    }

    public Chat update(Chat chat) {
        return em.merge(chat);
    }

    public List<Chat> loadAll() {
        return em.createNamedQuery("Chat.findAll", Chat.class).getResultList();
    }
}
