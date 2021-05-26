package com.psk.pyragas.ToolRent.utils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@SessionScoped
public class LoggerToFile implements Serializable {
    @Inject
    @ProjectDir
    private String projectFilesDir;

    private BufferedWriter bufferedWriter;

    private boolean isFileOpen;

    @PostConstruct
    public void init() {
        if (projectFilesDir == null) return;
        String destination = projectFilesDir + "logs\\";
        String logFileLocation = "methodLogs.txt";
        File outputFile = new File(destination + logFileLocation);
        try {
            Files.createDirectories(Paths.get(destination));
            if (outputFile.createNewFile()) {
                System.out.println("Log file successfully created at " + outputFile.getPath());
            }
            FileWriter fileWriter = new FileWriter(outputFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            isFileOpen = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logToFile(String textContent) {
        if (isFileOpen) {
            try {
                bufferedWriter.write(textContent);
                bufferedWriter.flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.out.println(ioException + "\n" + textContent);
            }
        }
    }

    @PreDestroy
    public void destroy() {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
