package com.psk.pyragas.ToolRent.utils;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.file.UploadedFile;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Named
@RequestScoped
@Getter
@Setter
public class FileUpload {
    private UploadedFile file;

    @Inject
    @ProjectDir
    private String projectFilesDir;

    private String destination;

    @PostConstruct
    public void init() {
        destination = projectFilesDir + "images\\";
        try {
            Files.createDirectories(Paths.get(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void upload() {
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBB");
        System.out.println(destination);
        try {
            copyFile(file.getFileName(), file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile(String fileName, InputStream in) {
        try {
            OutputStream out = new FileOutputStream(destination + fileName);

            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            in.close();

            out.write(buffer);
            out.close();
            System.out.println("New file created!");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}