package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.AdvertisementsDAO;
import com.psk.pyragas.ToolRent.dao.ProfilesDAO;
import com.psk.pyragas.ToolRent.entities.Advertisement;
import com.psk.pyragas.ToolRent.entities.Profile;
import com.psk.pyragas.ToolRent.interceptors.WillBeLogged;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

@WillBeLogged
@Model
public class CreateAdvertisement {

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    @Inject
    private AdvertisementsDAO advertisementsDAO;

    @Getter @Setter
    private Advertisement advertisementToCreate = new Advertisement();

    @PostConstruct
    public void init() {

    }

    @Transactional
    public String submitAdvertisement() {

        Profile profile = (Profile) externalContext.getSessionMap().get("user");
        this.advertisementToCreate.setProfile(profile);
        if(this.advertisementToCreate.getImage() == null) {
            this.advertisementToCreate.setImage("images/default.jpg");
        }
        this.advertisementsDAO.persist(this.advertisementToCreate);

        return "index.xhtml?faces-redirect=true";
    }


}
