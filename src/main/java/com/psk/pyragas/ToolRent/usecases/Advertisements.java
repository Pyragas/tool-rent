package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.AdvertisementsDAO;
import com.psk.pyragas.ToolRent.entities.Advertisement;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
@Getter
@Setter
public class Advertisements {
    private List<Advertisement> ads;

    @Inject
    AdvertisementsDAO adsDao;

    @PostConstruct
    public void init(){
        ads = adsDao.loadNumber(48);
    }

    private Advertisement selectedAd;
}
