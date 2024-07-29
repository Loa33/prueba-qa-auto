package org.example.constants;

import org.example.config.ConfigProperties;

public class Credentials {

    public static final String USERNAME = ConfigProperties.getProperty("USERNAME");
    public static final String PASSWORD = ConfigProperties.getProperty("PASSWORD");
}
