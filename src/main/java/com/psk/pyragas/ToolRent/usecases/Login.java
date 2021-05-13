package com.psk.pyragas.ToolRent.usecases;
import com.psk.pyragas.ToolRent.dao.ProfilesDAO;
import com.psk.pyragas.ToolRent.entities.Profile;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Named
@ApplicationScoped
public class Login implements Serializable {

    @Inject
    private ProfilesDAO profilesDAO;

    private Long loginState = null;

    private String email;
    private String password;

    public String checkFields() {
        List<Profile> profileList = profilesDAO.findOneByEmail(this.email);
        if(!profileList.isEmpty()) {
            Profile profile = profileList.get(0);
            if( profile.getEmail().equals(this.getEmail()) &&
                    profile.getPassword().equals(this.getPassword())) {
                this.setLoginState(profile.getId());
                return "index.xhtml";
            }
        }
        return "index.xhtml";
    }
}

