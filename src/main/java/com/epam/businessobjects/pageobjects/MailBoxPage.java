package com.epam.businessobjects.pageobjects;

import com.epam.businessobjects.pageobjects.decorator.elements.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class MailBoxPage extends AbstractPage {
    private static final Logger log = Logger.getLogger(MailBoxPage.class);

    private final String letterXPATH = "//div[@role='listitem'][.//span[contains(text(),'Test_Subject')]]";

    @FindBy(xpath = "//div[@aria-label][@role='button'][contains(@class, 'Ke')]")
    private Button write;

    @FindBy(xpath = letterXPATH)
    private Button myLetter;

    @FindBy(xpath = "//div[@role='button'][contains(@class, 'Wm')][div[contains(@class, 'rg')]]")
    private Button refresh;


    public MailBoxPage clickWriteButton() {
        log.info("Click Write Button");
        waitUntilBeClickable(write);
        write.click();
        return this;
    }


    public MailBoxPage waitMailboxPageLoad() {
        log.info("Wait mailbox load");
        waitPageURLEndsWith("#inbox");
        waitPageLoad();
        return this;
    }

    public MailBoxPage openTestLetrer() {
        log.info("Open Test Letter");
        waitUntilBeClickable(myLetter).click();
        return this;
    }

    public boolean isTestLetterPresen() {
        waitUntilBeClickable(refresh);
        return isElementPresent(By.xpath(letterXPATH));
    }

    public MailBoxPage refresh() {
        log.info("Refresh Letters");
        waitUntilBeClickable(refresh).click();
        return this;
    }
}