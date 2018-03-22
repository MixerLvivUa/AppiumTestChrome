package com.epam.preferences;

import org.apache.log4j.Logger;

import java.io.IOException;

public final class Preferences {
    private static final Logger log = Logger.getLogger(Preferences.class);
    public static final PreferencesTestGmail preferencesTestGmail = new PreferencesTestGmail();

    private Preferences() {
    }

    public static void initPreferences(String preferencesFileURL) throws IOException, PreferencesLoadException {
        log.info("Init preferences");
        preferencesTestGmail.loadPreferences(preferencesFileURL);
        log.info("Preferences init complete");
    }
}