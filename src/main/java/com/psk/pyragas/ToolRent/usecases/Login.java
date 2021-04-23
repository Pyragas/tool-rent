package com.psk.pyragas.ToolRent.usecases;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Login {

    @Getter
    private boolean isUserLoggedIn = false;

    public void setUserLoggedInToTrue() {
        this.isUserLoggedIn = true;
    }

    public void setUserLoggedInToFalse() {
        this.isUserLoggedIn = false;
    }

}