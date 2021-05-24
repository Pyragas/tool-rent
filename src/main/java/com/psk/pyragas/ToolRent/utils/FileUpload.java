package com.psk.pyragas.ToolRent.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Named
@RequestScoped
@Getter
@Setter
public class FileUpload {
    private UploadedFile file;

    @PostConstruct
    public void init(){
        try {
            Files.createDirectories(Paths.get(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String destination = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "/ToolRent/images/";

    public void upload() {

        System.out.println(file);
        try {
            copyFile(file.getFileName(), file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Thread.sleep(3000);
        System.out.println("ANEEEEEEE");



//        if (file != null) {
//            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
//            FacesContext.getCurrentInstance().addMessage(null, message);
//        }
    }

    public void copyFile(String fileName, InputStream in) {
        try {

            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(destination + fileName);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            // Possible problem: flush might not be needed.
            out.flush();
            out.close();

            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//    @SneakyThrows
//    public void handleFileUpload(FileUploadEvent event) {
//        Thread.sleep(3000);
//        System.out.println("ANEEEEEEE");
//        FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
}