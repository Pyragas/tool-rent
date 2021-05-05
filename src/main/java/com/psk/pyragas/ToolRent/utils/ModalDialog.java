package com.psk.pyragas.ToolRent.utils;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
@RequestScoped
public class ModalDialog {

    public void openModal(String contentView) {
        Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("fitViewport", true);
        options.put("contentHeight", "auto");
        options.put("dynamic", true);
        PrimeFaces.current().dialog().openDynamic(contentView, options, null);
    }

    public void onReturnFromLevel1(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Returned", event.getObject().toString()));
    }
}