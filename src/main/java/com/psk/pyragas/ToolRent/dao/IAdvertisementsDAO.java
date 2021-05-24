package com.psk.pyragas.ToolRent.dao;

import com.psk.pyragas.ToolRent.entities.Advertisement;

import java.util.List;

public interface IAdvertisementsDAO {

    public void persist(Advertisement ad) ;

    Advertisement findOne(Long id);

    Advertisement update(Advertisement ad);

    List<Advertisement> loadAll();

    List<Advertisement> loadNumber(int number);
}
