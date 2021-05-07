package com.psk.pyragas.ToolRent.usecases;
import lombok.Getter;

import javax.el.MethodExpression;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class Login implements Serializable {

    @Getter
    private boolean isLoggedIn;

    public boolean changeLoginState() {
        isLoggedIn = !isLoggedIn;
        return isLoggedIn;
    }
}

