package com.psk.pyragas.ToolRent.utils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@RequestScoped
public class LoggerFile implements Serializable {

    @Inject
    @ProjectDir
    private String projectFilesDir;

    BufferedWriter bufferedWriter;

    @PostConstruct
    public void init() {
        String destination = projectFilesDir + "logs\\";
        String logFileLocation = "methodLogs.txt";
        File outputFile = new File(destination + logFileLocation);

        try {
            Files.createDirectories(Paths.get(destination));
            if (outputFile.createNewFile()) {
                System.out.println("Log file successfully created at " + outputFile.getPath());
            } else {
                System.out.println("File already exists at " + outputFile.getPath());
            }
            FileWriter fileWriter = new FileWriter(outputFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logToFile(String textContent) {
        try {
            bufferedWriter.write(textContent);
            bufferedWriter.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println(ioException + "\n" + textContent);
        }
    }

    @PreDestroy
    private void destroy(){
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
