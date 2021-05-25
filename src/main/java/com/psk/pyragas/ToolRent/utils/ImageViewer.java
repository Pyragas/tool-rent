package com.psk.pyragas.ToolRent.utils;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Base64;

@Named
@SessionScoped
public class ImageViewer implements Serializable {
    public String getImage(String imageUrl) throws IOException {
        try {
            byte[] content = Files.readAllBytes(Paths.get(imageUrl));
            return Base64.getEncoder().encodeToString(content);
        } catch (NoSuchFileException e) {
            e.printStackTrace();
            return null;
        }
    }
}
