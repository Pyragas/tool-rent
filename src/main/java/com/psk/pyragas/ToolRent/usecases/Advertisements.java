package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.AdvertisementsDAO;
import com.psk.pyragas.ToolRent.dao.OrdersDAO;
import com.psk.pyragas.ToolRent.entities.Advertisement;
import com.psk.pyragas.ToolRent.entities.Order;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
@Getter
@Setter
public class Advertisements {
    private List<Advertisement> ads;

    private Advertisement selectedAd;

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
        System.out.println("Rent was called");

        Order order = new Order();
        order.setAdvertisement(selectedAd);
        ordersDAO.persist(order);
        adsDao.update(selectedAd);

        return "index.xhtml";
    }




}
