package com.psk.pyragas.ToolRent.usecases;
import com.psk.pyragas.ToolRent.dao.ProfilesDAO;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Getter
@Setter
@Named
@SessionScoped
public class Login implements Serializable {

    @Getter
    private boolean isLoggedIn;

    public boolean changeLoginState() {
        isLoggedIn = !isLoggedIn;
        return isLoggedIn;
    }

    private String username;
    private String password;

    public String checkFields() {
        boolean valid = ProfilesDAO.validate(username, password);
        if(valid) {
            isLoggedIn = true;
            return "index.xhtml";
        }
        return null;
    }
}

