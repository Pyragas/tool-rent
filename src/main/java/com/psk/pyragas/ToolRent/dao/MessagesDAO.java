package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.Message;
import com.psk.pyragas.ToolRent.utils.interceptors.WillBeLogged;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@WillBeLogged
@ApplicationScoped
public class MessagesDAO {
    @Inject
    private EntityManager em;

    public void persist(Message message) {
        em.persist(message);
    }

    public Message findOne(Long id) {
        return em.find(Message.class, id);
    }

    public Message update(Message message) {
        return em.merge(message);
    }

    public List<Message> loadAll() {
        return em.createNamedQuery("Message.findAll", Message.class).getResultList();
    }
}
