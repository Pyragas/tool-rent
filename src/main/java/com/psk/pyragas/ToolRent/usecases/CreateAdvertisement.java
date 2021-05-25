package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.AdvertisementsDAO;
import com.psk.pyragas.ToolRent.entities.Advertisement;
import com.psk.pyragas.ToolRent.entities.Profile;
import com.psk.pyragas.ToolRent.utils.interceptors.WillBeLogged;
import lombok.Getter;
import lombok.Setter;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;

@WillBeLogged
@ViewScoped
@Named
@Getter
public class CreateAdvertisement implements Serializable {

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    @Inject
    private AdvertisementsDAO advertisementsDAO;

    @Setter
    private Advertisement advertisementToCreate = new Advertisement();

    @Transactional
    public String submitAdvertisement(String photoUrl) {
        Profile profile = (Profile) externalContext.getSessionMap().get("user");
        this.advertisementToCreate.setProfile(profile);
        if(photoUrl == null) {
            advertisementToCreate.setImage("images/default.jpg");
        }
        else advertisementToCreate.setImage(photoUrl);
        this.advertisementsDAO.persist(advertisementToCreate);

        return "index.xhtml?faces-redirect=true";
    }
}
