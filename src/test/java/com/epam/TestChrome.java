package com.epam;

import com.epam.businessobjects.ChromeBO;
import com.epam.businessobjects.GoogleBO;
import com.epam.consts.Consts;
import com.epam.drivers.SingletonDriver;
import com.epam.preferences.Preferences;
import com.epam.preferences.PreferencesLoadException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestChrome {
    private static final Logger log = Logger.getLogger(TestChrome.class);

    @BeforeTest
    public void preferencesLoad() throws IOException, PreferencesLoadException {
        Preferences.initPreferences(Consts.CONST_PROPERTY_FILE_NAME);
    }

    @Test
    public void testGmailDeleteMessage() {
        log.info("Start Chrome testing");
        ChromeBO chromeBO = new ChromeBO();
        chromeBO.startChrome();
        chromeBO.createNewTabAndOpenPage("https://www.google.com.ua/");
        GoogleBO googleBO = new GoogleBO();
        String searchText = "Android";
        googleBO.googleIt(searchText);
        Assert.assertTrue(googleBO.isResultContainsText(searchText));
        log.info("Chrome testing done");
    }

    @AfterTest
    public void coloseDriver() {
        SingletonDriver.closeDriver();
    }
}