package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.ProfilesDAO;
import com.psk.pyragas.ToolRent.entities.Profile;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;

@ViewScoped
@Getter
@Setter
@Named
public class Registration implements Serializable {
    @Inject
    private ProfilesDAO profilesDAO;

    private Profile profileToCreate = new Profile();

    private Boolean isLegalPerson;

    @Transactional
    public String createProfile() {
        profilesDAO.persist(profileToCreate);
        return "?faces-redirect=true";
    }

}
