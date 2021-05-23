package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.AdvertisementsDAO;
import com.psk.pyragas.ToolRent.dao.OrdersDAO;
import com.psk.pyragas.ToolRent.entities.Advertisement;
import com.psk.pyragas.ToolRent.entities.Order;
import com.psk.pyragas.ToolRent.entities.Profile;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;



@Getter
@Setter
@Named
@ViewScoped
public class DetailedAdvertisement implements Serializable {

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    @Inject
    private AdvertisementsDAO advertisementsDAO;

    @Inject
    private OrdersDAO ordersDAO;

    @Getter @Setter
    private Advertisement currentAdvertisement;

    @Getter @Setter
    private Order orderToCreate = new Order();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long advertisementId = Long.parseLong(requestParameters.get("advertisementId"));
        currentAdvertisement = advertisementsDAO.findOne(advertisementId);
    }

    @Transactional
    public String createOrder() {
        Profile profile = (Profile) externalContext.getSessionMap().get("user");
        orderToCreate.setAdvertisement(currentAdvertisement);
        orderToCreate.setProfile(profile);
        ordersDAO.persist(orderToCreate);

        return "index.xhtml";
    }

}
