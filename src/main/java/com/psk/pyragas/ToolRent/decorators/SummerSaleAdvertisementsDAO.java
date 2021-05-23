package com.psk.pyragas.ToolRent.decorators;

import com.psk.pyragas.ToolRent.dao.AdvertisementsDAO;
import com.psk.pyragas.ToolRent.dao.IAdvertisementsDAO;
import com.psk.pyragas.ToolRent.entities.Advertisement;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

@Decorator
public abstract class SummerSaleAdvertisementsDAO implements IAdvertisementsDAO {

    @Inject
    @Delegate @Any
    private IAdvertisementsDAO advertisementsDAO;


    @Override
    public void persist(Advertisement ad) {

    }

    @Override
    public Advertisement findOne(Long id) {
        Advertisement advertisement = advertisementsDAO.findOne(id);
        advertisement.setRentPrice(advertisement.getRentPrice().multiply(BigDecimal.valueOf(.9)));
        return advertisement;
    }

    @Override
    public Advertisement update(Advertisement ad) {
        return advertisementsDAO.update(ad);
    }

    @Override
    public List<Advertisement> loadAll() {
        return null;
    }

    @Override
    public List<Advertisement> loadNumber(int number) {
        return advertisementsDAO.loadNumber(number);

    }
}
