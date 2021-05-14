package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.OrdersDAO;
import com.psk.pyragas.ToolRent.entities.Order;
import com.psk.pyragas.ToolRent.entities.Profile;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

@Model
@Getter
@Setter
public class MyOrders {

    private List<Order> orders;

    @Inject
    OrdersDAO ordersDAO;

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    Profile user;

    @PostConstruct
    public void init() {
        user = (Profile) externalContext.getSessionMap().get("user");
        orders = ordersDAO.loadCustomerOrders(user.getId());
    }

}
