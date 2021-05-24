package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.ProfilesDAO;
import com.psk.pyragas.ToolRent.entities.Profile;
import com.psk.pyragas.ToolRent.utils.interceptors.WillBeLogged;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@WillBeLogged
@Model
public class MyProfile {

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    @Getter
    @Setter
    private Profile profile;

    @Inject
    private ProfilesDAO profilesDAO;

    @PostConstruct
    public void init() {
        profile = profilesDAO.findOne(((Profile) externalContext.getSessionMap().get("user")).getId());
    }

}
