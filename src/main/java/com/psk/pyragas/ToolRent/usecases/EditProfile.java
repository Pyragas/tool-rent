package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.ProfilesDAO;
import com.psk.pyragas.ToolRent.entities.Profile;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class EditProfile {

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    @Getter
    @Setter
    private Profile profile;

    @Inject
    private ProfilesDAO profilesDAO;

    @PostConstruct
    public void init() {
        profile = ((Profile) externalContext.getSessionMap().get("user"));
    }

    @Transactional
    public String updateProfile() {
        profilesDAO.update(profile);
        return "index.xhtml?faces-redirect=true";
    }
}
