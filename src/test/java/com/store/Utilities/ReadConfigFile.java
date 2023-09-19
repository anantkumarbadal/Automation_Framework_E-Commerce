package com.store.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {

    //Using Properties class to read the file

    Properties properties;

    String filePath = "config.properties";

    public void readConfigFile() {
        properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getBaseUrl()
    {
        String value = properties.getProperty("baseUrl");

        //checking if the value is not null
        if (value != null)
        {
            return value;
        }
        else
            throw new RuntimeException("url not specified in config file");
    }



}
