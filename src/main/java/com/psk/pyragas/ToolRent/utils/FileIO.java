package com.psk.pyragas.ToolRent.utils;

import javax.enterprise.context.RequestScoped;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RequestScoped
public class FileIO {

    public void writeToTextFile(String fileLocation, String textContent) {
        writeToTextFile(fileLocation, textContent, true);
    }

    public void writeToTextFile(String fileLocation, String textContent, boolean append) {
        fileLocation = "D:/Data/" + fileLocation;
        File outputFile = new File(fileLocation);

        if(!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }

        try {
            if (outputFile.createNewFile()) {
                System.out.println("Log file successfully created at " + outputFile.getPath());
            } else {
                System.out.println("File already exists at " + outputFile.getPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter bufferedWriter;

        try {
            FileWriter fileWriter = new FileWriter(outputFile, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textContent);
            bufferedWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println(ioException + "\n" + textContent);
        }
    }
}
