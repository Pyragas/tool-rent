package com.psk.pyragas.ToolRent.utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.swing.filechooser.FileSystemView;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Startup
@Singleton
public class Directories {
    private static String projectFilesDir;

    @Produces
    @ProjectDir
    public static String getProjectFilesDir() {
        return projectFilesDir;
    }

    @PostConstruct
    private void init() {
        try {
            projectFilesDir = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\ToolRent\\";
            Files.createDirectories(Paths.get(projectFilesDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
