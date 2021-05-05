package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.AdvertisementsDAO;
import com.psk.pyragas.ToolRent.dao.ItemsDAO;
import com.psk.pyragas.ToolRent.dao.ProfilesDAO;
import com.psk.pyragas.ToolRent.entities.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class NewAdvertisement {

    @Inject
    private AdvertisementsDAO advertisementsDAO;

    @Inject
    private ProfilesDAO profilesDAO;

    @Getter @Setter
    private Advertisement advertisementToCreate = new Advertisement();

    @PostConstruct
    public void init() {

    }

    @Transactional
    public String submitAdvertisement() {

        //TODO: remove mocked user and use real user
        System.out.println("Submitting advertisement");
        NaturalPerson naturalPerson = new NaturalPerson();
        naturalPerson.setName("mock");
        this.profilesDAO.persist(naturalPerson);
        this.advertisementToCreate.setProfile(naturalPerson);
        this.advertisementsDAO.persist(this.advertisementToCreate);

        return "addNewItem.xhtml?faces-redirect=true&advertisementId=" + this.advertisementToCreate.getId();
    }


}
