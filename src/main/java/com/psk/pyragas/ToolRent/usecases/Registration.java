package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.ProfilesDAO;
import com.psk.pyragas.ToolRent.entities.LegalPerson;
import com.psk.pyragas.ToolRent.entities.NaturalPerson;
import com.psk.pyragas.ToolRent.entities.Profile;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    @Inject
    private ProfilesDAO profilesDAO;

    private LegalPerson legalPersonToCreate;
    private NaturalPerson naturalPersonToCreate;
    private Profile profileToCreate;

    private Boolean isLegalPerson;

    public void setIsLegalPerson(Boolean legalPerson) {
        isLegalPerson = legalPerson;
        if (legalPerson) {
            legalPersonToCreate = new LegalPerson();
            profileToCreate = legalPersonToCreate;
        } else {
            naturalPersonToCreate = new NaturalPerson();
            profileToCreate = naturalPersonToCreate;
        }
    }

    @Transactional
    public String createProfile() {
        profilesDAO.persist(profileToCreate);
        externalContext.getSessionMap().put("user", profileToCreate);
        return "index.xhtml?faces-redirect=true";
    }

}
