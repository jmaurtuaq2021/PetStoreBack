package com.proyecto.pacifico.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static void PopulateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.ReadProperty();
    }

    private void ReadProperty() throws IOException {

        Properties p = new Properties();
        String propEnv = "ConfigIntegracion.properties";
        //String propEnv = "ConfigCertificacion.properties";
        //String propEnv = "ConfigProduccion.properties";

        String localPath = System.getProperty("user.dir") + "/src/main/resources/";
        InputStream inputStream = new FileInputStream(localPath + propEnv);
        p.load(inputStream);

        Settings.PathLogs = p.getProperty("PathLogs");
        Settings.PathConfig = p.getProperty("PathConfig");

        Settings.Environment = p.getProperty("Environment");
        Settings.UrlApiBase = p.getProperty("UrlApiBase");
        Settings.SubscriptionKeyApiNE = p.getProperty("SubscriptionKeyApiNE");
        Settings.UrlApiNEPath = p.getProperty("UrlApiNEPath");


    }

}