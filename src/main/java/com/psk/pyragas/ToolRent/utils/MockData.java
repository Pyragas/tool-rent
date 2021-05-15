package com.psk.pyragas.ToolRent.utils;

import com.psk.pyragas.ToolRent.dao.*;
import com.psk.pyragas.ToolRent.entities.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@Singleton
@Startup
public class MockData {

    @Inject
    private AdvertisementsDAO advertisementsDAO;

    @Inject
    private OrdersDAO ordersDAO;

    @Inject
    private ProfilesDAO profilesDAO;



    @PostConstruct
    private void init() {

        // Create object
        Advertisement advertisement = new Advertisement();
        Order order = new Order();
        NaturalPerson naturalPerson = new NaturalPerson();
        LegalPerson legalPerson = new LegalPerson();

        // Fill in object data
        advertisement.setFuelType("Dyzelinas");
        advertisement.setMeasurements("4x4x2");
        advertisement.setName("Ekskavatorius Samsung 3310");
        advertisement.setOperatorPrice(BigDecimal.valueOf(99.99));
        advertisement.setRentPrice(BigDecimal.valueOf(39.99));
        advertisement.setStatus("Laisvas");
        advertisement.setText("Puikus ekskavatorius, puikiai kasa duobes");
        advertisement.setType("Ekskavatorius");
        advertisement.setWeight(4400.0);
        advertisement.setFuelLevel("Pilnas");
        advertisement.setLocation("Didlaukio g. 59");
        advertisement.setStatus("Laisvas");

        order.setDeliveryLocation("Naugarduko g. 24");
        order.setOperator(Boolean.FALSE);
        order.setPrice(BigDecimal.valueOf(345.12));
        order.setRentTimeStart(new Date(11));
        order.setRentTimeEnd(new Date(12));
        order.setStatus("Tvirinamas");
        order.setProfile(naturalPerson);
        order.setAdvertisement(advertisement);

        ArrayList<Advertisement> advertisements = new ArrayList<>();
        advertisements.add(advertisement);
        naturalPerson.setAds(advertisements);
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);
        naturalPerson.setOrders(orders);
        naturalPerson.setEmail("xkavatorius@one.lt");
        naturalPerson.setPassword("slaptas");
        naturalPerson.setPhoneNo("867421299");
        naturalPerson.setRating((float) 8.3);
        naturalPerson.setPersonalCode("123");
        naturalPerson.setName("Bronis");
        naturalPerson.setSurname("Burokas");

        legalPerson.setEmail("statyknama@stroike.com");
        legalPerson.setPassword("slaptesnis");
        legalPerson.setPhoneNo("4455");
        legalPerson.setRating((float) 7.4);
        legalPerson.setCompanyCode("123");

        // Catch error of same data insertion
        // Persist data, order is important!
        try{
            advertisementsDAO.persist(advertisement);
            ordersDAO.persist(order);
            profilesDAO.persist(naturalPerson);
            profilesDAO.persist(legalPerson);
            System.out.println("CREATED MOCK DATA");
        } catch (Exception e){
            System.out.println("Couldn't add data");
        }

    }
}
