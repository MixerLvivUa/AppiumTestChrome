package com.epam.businessobjects;


import com.epam.businessobjects.pageobjects.LoginPage;
import com.epam.testdata.TestData;

public class AuthorizationBO {
    public AuthorizationBO authorizeAs(TestData testData) {
        new LoginPage()
                .openPage()
                .typeMail(testData.getUserMail())
                .typePassword(testData.getUserPassword());
        return this;
    }
}