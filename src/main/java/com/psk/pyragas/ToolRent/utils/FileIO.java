package com.psk.pyragas.ToolRent.utils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RequestScoped
public class FileIO {

    @Inject
    private SysOutPrinter sysOutPrinter;

    private void createNewFile(File file) {
        try {
            if (file.createNewFile()) {
                sysOutPrinter.printMessageNewLine("Log file successfully created at " + file.getPath());
            }
            else {
                sysOutPrinter.printMessageNewLine("Failed to create log file at " + file.getPath());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            sysOutPrinter.printMessageNewLine(ioException.toString());
        }
    }

    public void writeToTextFile(String fileLocation, String textContent) {
        writeToTextFile(fileLocation, textContent, true);
    }

    public void writeToTextFile(String fileLocation, String textContent, boolean append) {
        File outputFile = new File(fileLocation);
        BufferedWriter bufferedWriter = null;
        if (!outputFile.exists()) {
            createNewFile(outputFile);
        }
        try {
            FileWriter fileWriter = new FileWriter(outputFile, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textContent);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
            sysOutPrinter.printMessage(ioException + "\n" + textContent);
        }
        finally {
            try {
                bufferedWriter.close();
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
                sysOutPrinter.printMessageNewLine(ioException.toString());
            }
        }
    }
}
