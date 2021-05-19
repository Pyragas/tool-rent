package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.AdvertisementsDAO;
import com.psk.pyragas.ToolRent.dao.OrdersDAO;
import com.psk.pyragas.ToolRent.entities.Advertisement;
import com.psk.pyragas.ToolRent.entities.Order;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Named
@ViewScoped
public class Advertisements implements Serializable {
    private List<Advertisement> ads;

    private Advertisement selectedAd;

    FacesContext context = FacesContext.getCurrentInstance();
    Map<String, String> map = context.getExternalContext().getRequestParameterMap();

    @Inject
    AdvertisementsDAO adsDao;

    @Inject
    OrdersDAO ordersDAO;

    @PostConstruct
    public void init(){
        ads = adsDao.loadNumber(48);
    }

    @Transactional
    public String rentItem() {

        Order order = new Order();
        order.setPrice(new BigDecimal(66));
        order.setAdvertisement(selectedAd);
        ordersDAO.persist(order);

        return "detailed_advertisement.xhtml?faces-redirect=true&advertisementId=" + selectedAd.getId();
    }

}
