package com.psk.pyragas.ToolRent.usecases;
import lombok.Getter;

import javax.enterprise.inject.Model;
import java.io.Serializable;

@Model
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