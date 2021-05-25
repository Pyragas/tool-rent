package com.psk.pyragas.ToolRent.utils;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;

@Named
@ViewScoped
@Getter
@Setter
public class ImageUpload implements Serializable {
    private UploadedFile file;

    @Inject
    @ProjectDir
    private String projectFilesDir;

    private String destination;

    private String fileName;

    private byte[] fileContents;

    @PostConstruct
    public void init() {
        destination = projectFilesDir + "images\\";
        try {
            Files.createDirectories(Paths.get(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getImageContentsAsBase64() {
        return Base64.getEncoder().encodeToString(file.getContent());
    }

    private int maxFileSize = 100000;

    private String url;

    public String handlePhotoUpload(FileUploadEvent event) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        file = event.getFile();
        fileName = file.getFileName();
        fileContents = file.getContent();
        url = destination + fileName;
        return url;
    }

    public void upload() {
        copyFile(fileName, fileContents);
    }

    public void copyFile(String fileName, byte[] content) {
        CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        OutputStream out = new FileOutputStream(url);
                        out.write(content);
                        out.close();
                        System.out.println("New file " + fileName + " uploaded.");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
        );
    }
}