package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.ProfilesDAO;
import com.psk.pyragas.ToolRent.entities.Profile;
import com.psk.pyragas.ToolRent.utils.interceptors.WillBeLogged;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.PrimeFaces;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.Serializable;

@WillBeLogged
@ViewScoped
@Named
@Getter
@Setter
@Transactional
public class EditProfile implements Serializable {
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    private Profile profile;

    private Boolean isReadOnly;

    @Inject
    private ProfilesDAO profilesDAO;

    @PostConstruct
    public void init() {
        profile = profilesDAO.findOne(((Profile) externalContext.getSessionMap().get("user")).getId());
        isReadOnly = true;
    }

    public void updateProfile() {
        try {
            profilesDAO.update(profile);
            externalContext.getSessionMap().put("user", profile);
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?faces-redirect=true");
        }
        catch (OptimisticLockException | IOException e) {
            PrimeFaces.current().executeScript("PF('optimisticButton').jq.click()");
        }
    }

    public void addMessage(FacesMessage.Severity messageType, String summary, String detail) {
        FacesMessage message = new FacesMessage(messageType, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void refreshAndContinue() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("my_profile.xhtml?id=" + profile.getId() );
        addMessage(FacesMessage.SEVERITY_INFO, "Data has been successfully updated.", "Refresh and update.");
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void overwrite() throws IOException {
        Profile profileInDB = profilesDAO.findOne(profile.getId());
        try {
            BeanUtils.copyProperties(profileInDB, profile);
            profilesDAO.update(profileInDB);
            FacesContext.getCurrentInstance().getExternalContext().redirect("my_profile.xhtml");
            addMessage(FacesMessage.SEVERITY_INFO, "Duomenys buvo perrašyti.", "Perrašyti.");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("my_profile.xhtml?id=" + profile.getId());
            addMessage(FacesMessage.SEVERITY_INFO, "Atsiprašome, negalima perrašyti.", "Keiskite iš naujo.");
        }
    }


}
