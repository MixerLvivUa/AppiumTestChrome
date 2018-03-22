package com.epam.preferences;

public class PreferencesLoadException extends Exception {
    public PreferencesLoadException() {
        super("Init failed");
    }

    public PreferencesLoadException(String message) {
        super(message);
    }

    private static final long serialVersionUID = 1L;
}
