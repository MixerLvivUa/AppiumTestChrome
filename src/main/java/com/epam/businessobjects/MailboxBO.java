package com.epam.businessobjects;

import com.epam.businessobjects.pageobjects.LetterPage;
import com.epam.businessobjects.pageobjects.MailBoxPage;
import com.epam.businessobjects.pageobjects.WriteLetterPage;

public class MailboxBO {
    public MailboxBO createNewMessage() {
        new MailBoxPage().clickWriteButton();
        new WriteLetterPage()
                .typeTo("mixer.log4j@gmail.com")
                .typeSubject("Test_Subject")
                .typeBody("Test_Body")
                .clickSend();
        return this;
    }

    public MailboxBO deleteTestLetter() {
        new MailBoxPage()
                .openTestLetrer();
        new LetterPage()
                .clickDelete();
        return this;
    }

    public boolean verifyDeletion() {
        return new MailBoxPage().refresh().isTestLetterPresen();
    }
}
