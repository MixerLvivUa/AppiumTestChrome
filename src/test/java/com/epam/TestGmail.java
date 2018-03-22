package com.epam;

import com.epam.businessobjects.AuthorizationBO;
import com.epam.businessobjects.MailboxBO;
import com.epam.consts.Consts;
import com.epam.preferences.Preferences;
import com.epam.preferences.PreferencesLoadException;
import com.epam.testdata.DataLoader;
import com.epam.testdata.DataProviderTransformer;
import com.epam.testdata.TestData;
import com.epam.testdata.TestDataList;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class TestGmail {
    private static final Logger log = Logger.getLogger(TestGmail.class);

    @DataProvider(name = "userData", parallel = true)
    public static Object[][] getDataProvider() throws JAXBException {
        return DataProviderTransformer.transformListToObjects(DataLoader.loadXMLFromResources(Consts.CONST_INPUT_DATA, TestDataList.class).getTestDataList());
    }

    @BeforeTest
    public void preferencesLoad() throws IOException, PreferencesLoadException {
        Preferences.initPreferences(Consts.CONST_PROPERTY_FILE_NAME);
    }

    @Test(dataProvider = "userData")
    public void testGmailDeleteMessage(TestData testData) {
        log.info("testGmailDeleteMessage start");
        new AuthorizationBO()
                .authorizeAs(testData);

        MailboxBO mailBoxBO = new MailboxBO();
        mailBoxBO.createNewMessage();
        mailBoxBO.deleteTestLetter();
        Assert.assertFalse(mailBoxBO.verifyDeletion());
        log.info("testGmailDeleteMessage done");
    }
}