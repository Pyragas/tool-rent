package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.Message;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class MessagesDAO {
    @Inject
    private EntityManager em;

    public void persist(Message message) {
        this.em.persist(message);
    }

    public Message findOne(Long id) {
        return this.em.find(Message.class, id);
    }

    public Message update(Message message) {
        return this.em.merge(message);
    }

    public List<Message> loadAll() {
        return this.em.createNamedQuery("Message.findAll", Message.class).getResultList();
    }
}
