package com.psk.pyragas.ToolRent.utils;

import com.psk.pyragas.ToolRent.dao.*;
import com.psk.pyragas.ToolRent.entities.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Singleton
@Startup
public class MockData {

    @Inject
    private ProfilesDAO profilesDAO;

    @PostConstruct
    private void init() {
        NaturalPerson naturalPerson = new NaturalPerson();
        naturalPerson.setEmail("xkavatorius@one.lt");
        naturalPerson.setPassword("slaptas");
        naturalPerson.setPhoneNo("867421299");
        naturalPerson.setRating((float) 8.3);
        naturalPerson.setPersonalCode("123");
        naturalPerson.setName("Bronis");
        naturalPerson.setSurname("Burokas");

        LegalPerson legalPerson = new LegalPerson();
        legalPerson.setName("Statita");
        legalPerson.setEmail("statyknama@stroike.com");
        legalPerson.setPassword("slaptesnis");
        legalPerson.setPhoneNo("4455");
        legalPerson.setRating((float) 7.4);
        legalPerson.setCompanyCode("123");

        Advertisement advertisement = new Advertisement();
        advertisement.setFuelType("Dyzelinas");
        advertisement.setMeasurements("4x4x2");
        advertisement.setName("Ekskavatorius Samsung 3310");
        advertisement.setOperatorPrice(BigDecimal.valueOf(99.99));
        advertisement.setRentPrice(BigDecimal.valueOf(39.99));
        advertisement.setStatus("FREE");
        advertisement.setText("Puikus ekskavatorius, puikiai kasa duobes");
        advertisement.setType("Ekskavatorius");
        advertisement.setWeight(4400.0);
//        advertisement.setImage("images/samsung.jpg");
        advertisement.setFuelLevel("Pilnas");
        advertisement.setLocation("Didlaukio g. 59");
        advertisement.setStatus("Laisvas");

        Order order = new Order();
        order.setAdvertisement(advertisement);
        order.setDeliveryLocation("Naugarduko g. 24");
        order.setOperator(Boolean.FALSE);
        order.setRentPrice(BigDecimal.valueOf(345.12));
        order.setOperatorPrice(BigDecimal.valueOf(345.12));
        order.setRentTimeStart(LocalDateTime.now());
        order.setRentTimeEnd(LocalDateTime.now().plusDays(1));
        order.setStatus("IN_PROGRESS");

//        Maps everything in person and these tables so we don't need to persist everything one by one
//        THIS IS HOW TO PERSIST DATA IN MAPPED ENTITIES
        legalPerson.addAdvertisement(advertisement);
        naturalPerson.addOrder(order);

        // Catch error of same data insertion
        // Persist data, order is important!
        try{
            profilesDAO.persist(legalPerson);
            profilesDAO.persist(naturalPerson);
            System.out.println("CREATED MOCK DATA");
        } catch (Exception e){
            System.out.println("Couldn't add data");
            e.printStackTrace();
        }
    }
}
