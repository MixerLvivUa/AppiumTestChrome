package com.epam.preferences;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class PreferencesTestGmail extends PreferencesLoader {
    private static final Logger log = Logger.getLogger(PreferencesTestGmail.class);

    private String driverType = null;
    private String driverURL = null;
    private Integer implicitlyWait = null;
    private Integer timeOutInSeconds = null;
    private Integer sleepInMillis = null;
    private Integer threadsLimit = null;

    @Override
    public void loadPreferences(String preferencesFileURL) throws IOException, PreferencesLoadException {
        log.info("Load TestGmail preferences");
        try {
            prop = new Properties();
            prop.load(PreferencesTestGmail.class.getResourceAsStream(preferencesFileURL));
            driverType = loadProperty("driver.type");
            driverURL = loadProperty("driver.URL");
            implicitlyWait = Integer.parseInt(loadProperty("wait.implicitlyWait"));
            timeOutInSeconds = Integer.parseInt(loadProperty("wait.timeOutInSeconds"));
            sleepInMillis = Integer.parseInt(loadProperty("wait.sleepInMillis"));
            threadsLimit = Integer.parseInt(loadProperty("threads.limit"));
        } catch (IOException | PreferencesLoadException exception) {
            log.error(exception.getMessage());
            throw exception;
        }
        log.info("TestGmail preferences loaded");
    }

    public String getDriverType() {
        return driverType;
    }

    public String getDriverURL() {
        return driverURL;
    }

    public Integer getImplicitlyWait() {
        return implicitlyWait;
    }

    public Integer getTimeOutInSeconds() {
        return timeOutInSeconds;
    }

    public Integer getSleepInMillis() {
        return sleepInMillis;
    }

    public Integer getThreadsLimit() {
        return threadsLimit;
    }
}