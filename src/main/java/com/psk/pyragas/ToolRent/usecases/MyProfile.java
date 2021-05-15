package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.entities.Profile;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@Model
public class MyProfile {

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    @Getter
    @Setter
    private Profile profile;

    @PostConstruct
    public void init() {
        profile = ((Profile) externalContext.getSessionMap().get("user"));
    }

}
