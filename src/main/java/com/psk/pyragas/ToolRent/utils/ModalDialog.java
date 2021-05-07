package com.psk.pyragas.ToolRent.utils;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import javax.el.MethodExpression;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Named
@RequestScoped
public class ModalDialog {

    public Map<String, Object> loginOptions() {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        options.put("contentHeight", "280px");
        options.put("contentWidth", "auto");
        return options;
    }

    public void openModal(String content, Map<String, Object> options) {
        PrimeFaces.current().dialog().openDynamic(content, options, null);
    }

    public void closeModal(Object object) {
        PrimeFaces.current().dialog().closeDynamic(object);
    }

    public void handleReturn(SelectEvent event){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(event.getObject().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}