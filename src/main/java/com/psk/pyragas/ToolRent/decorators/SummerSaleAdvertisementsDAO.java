package com.psk.pyragas.ToolRent.decorators;

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
        advertisementsDAO.persist(ad);
    }

    @Override
    public Advertisement findOne(Long id) {
        Advertisement advertisement = advertisementsDAO.findOne(id);
        advertisement.setRentPrice(advertisement.getRentPrice().multiply(BigDecimal.valueOf(.5)));
        advertisement.setName(advertisement.getName() + " (Vasaros akcija)" );
        return advertisement;
    }

    @Override
    public Advertisement update(Advertisement ad) {
        return advertisementsDAO.update(ad);
    }

    @Override
    public List<Advertisement> loadAll() {
        List<Advertisement> advertisements = advertisementsDAO.loadAll();
        for(Advertisement advertisement : advertisements) {
            advertisement.setRentPrice(
                    advertisement.getRentPrice().multiply(BigDecimal.valueOf(.5))
            );
            advertisement.setName(advertisement.getName() + " (Vasaros akcija)" );
        }
        return advertisements;
    }

    @Override
    public List<Advertisement> loadNumber(int number) {

        List<Advertisement> advertisements =  advertisementsDAO.loadNumber(number);
        for(Advertisement advertisement : advertisements) {
            advertisement.setRentPrice(
                    advertisement.getRentPrice().multiply(BigDecimal.valueOf(.5))
            );
            advertisement.setName(advertisement.getName() + " (Vasaros akcija)" );
        }
        return advertisements;
    }
}
