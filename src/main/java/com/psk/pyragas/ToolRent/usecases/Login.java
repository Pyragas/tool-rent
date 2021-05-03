package com.psk.pyragas.ToolRent.usecases;
import lombok.Getter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class Login implements Serializable {

    @Getter
    private boolean isUserLoggedIn = false;

    public void setUserLoggedInToTrue() {
        this.isUserLoggedIn = true;
    }

    public void setUserLoggedInToFalse() {
        this.isUserLoggedIn = false;
    }

}