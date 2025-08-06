package com.ecsa.mt2mx.util;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

import java.util.logging.Logger;

@Component
public class StartupInitializer {
    private static final Logger LOGGER = Logger.getLogger(StartupInitializer.class.getName());

    @Value("${converter.input-folder}")
    private String inputFolder;

    @Value("${converter.output-folder}")
    private String outputFolder;

    @PostConstruct
    public void init() {
        createFolderIfNotExists(inputFolder);
        createFolderIfNotExists(outputFolder);
    }

    private void createFolderIfNotExists(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            boolean created = folder.mkdir();
            if (created) {
                LOGGER.info("Carpeta creada: " + folderPath);
            } else {
                LOGGER.warning("No se pudo crear la carpeta: " + folderPath);
            }
        } else {
            LOGGER.info("Carpeta ya existe: " + folderPath);
        }
    }
}
