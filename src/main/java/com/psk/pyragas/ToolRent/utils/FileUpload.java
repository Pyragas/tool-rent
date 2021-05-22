package com.psk.pyragas.ToolRent.utils;

import lombok.SneakyThrows;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class FileUpload {
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    @SneakyThrows
    public void upload() {
        Thread.sleep(5000);
        System.out.println("ANEEEEEEE");
//        if (file != null) {
//            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
//            FacesContext.getCurrentInstance().addMessage(null, message);
//        }
    }

    @SneakyThrows
    public void handleFileUpload(FileUploadEvent event) {
        Thread.sleep(50000);
        System.out.println("ANEEEEEEE");
        FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}