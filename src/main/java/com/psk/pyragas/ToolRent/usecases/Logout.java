package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.utils.interceptors.WillBeLogged;

import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@WillBeLogged
@Model
public class Logout {
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    public String logoutUser(){
        externalContext.invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }
}
