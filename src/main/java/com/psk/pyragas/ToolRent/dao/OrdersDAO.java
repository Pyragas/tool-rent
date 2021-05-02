package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class OrdersDAO {
    @Inject
    private EntityManager em;

    public void persist(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    public Order update(Order order) {
        return em.merge(order);
    }

    public List<Order> loadAll() {
        return em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }
}
