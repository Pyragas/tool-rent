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

@Named
@ViewScoped
@Getter
@Setter
public class AdvertisementDetails implements Serializable {

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    @Inject
    private AdvertisementsDAO advertisementsDAO;

    @Inject
    private OrdersDAO ordersDAO;

    private Advertisement currentAdvertisement;

    private Order orderToCreate = new Order();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String adIdParameter = requestParameters.get("advertisementId");
        System.out.println("HHHHHHHHHHHHH");
        System.out.println(adIdParameter);
        if(adIdParameter == null) return;
        Long advertisementId = Long.parseLong(adIdParameter);
        currentAdvertisement = advertisementsDAO.findOne(advertisementId);
    }

    @Transactional
    public String createOrder() {
        Profile profile = (Profile) externalContext.getSessionMap().get("user");
        orderToCreate.setProfile(profile);
        orderToCreate.setAdvertisement(currentAdvertisement);
        ordersDAO.persist(orderToCreate);

        return "index.xhtml?faces-redirect=true";
    }
}
