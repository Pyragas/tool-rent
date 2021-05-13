package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.ItemsDAO;
import com.psk.pyragas.ToolRent.dao.OrdersDAO;
import com.psk.pyragas.ToolRent.entities.Advertisement;
import com.psk.pyragas.ToolRent.entities.Item;
import com.psk.pyragas.ToolRent.entities.Order;
import com.psk.pyragas.ToolRent.entities.Profile;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ViewScoped
@Named
@Getter
@Setter
@Transactional
public class ExampleItem implements Serializable {

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    @Inject
    private ItemsDAO itemsDAO;

    @Inject
    private OrdersDAO ordersDAO;

    @Getter @Setter
    private Order orderToCreate = new Order();

    @Getter
    @Setter
    private Item item;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long itemId = Long.parseLong(requestParameters.get("itemId"));
        this.item = itemsDAO.findOne(itemId);
    }


    @Transactional
    public String rent() {
        System.out.println("Paspaude nuomoti");
        Profile profile = (Profile) externalContext.getSessionMap().get("user");

        List<Item> items = new ArrayList<>();
        items.add(item);

        orderToCreate.setItems(items);
        orderToCreate.setProfile(profile);
        ordersDAO.persist(orderToCreate);

        // Update item
        item.setStatus("Used");
        itemsDAO.update(item);

        return "index.xhtml";
    }
}
