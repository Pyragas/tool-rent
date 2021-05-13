package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.ProfilesDAO;
import com.psk.pyragas.ToolRent.entities.Profile;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;

@Getter
@Setter
@Model
public class Login implements Serializable {

    @Inject
    private ProfilesDAO profilesDAO;

    private String email;
    private String password;

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    public void checkFields() {
        Profile profile = profilesDAO.findOneByEmailAndPassword(this.email, this.password);
        if (profile != null) {
            externalContext.getSessionMap().put("user", profile);
            PrimeFaces.current().dialog().closeDynamic("profile.xhtml?faces-redirect=true");
        }
        else {
//            TODO: show error in login form
        }
    }
}

