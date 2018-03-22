package com.epam.businessobjects.pageobjects;

import com.epam.businessobjects.pageobjects.decorator.elements.Button;
import com.epam.businessobjects.pageobjects.decorator.elements.InputField;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class WriteLetterPage extends AbstractPage {
    private static final Logger log = Logger.getLogger(MailBoxPage.class);

    @FindBy(id = "composeto")
    private InputField composeto;
    @FindBy(id = "cmcsubj")
    private InputField subject;
    @FindBy(id = "cmcbody")
    private InputField body;
    @FindBy(xpath = "//div[@role='button'][contains(@class, 'Ee')]")
    private Button send;

    public WriteLetterPage typeTo(String to) {
        log.info("Type letter receiver");
        waitUntilBeClickable(composeto);
        composeto.click();
        composeto.sendKeys(to);
        return this;
    }

    public WriteLetterPage typeSubject(String subj) {
        log.info("Type letter subject");
        waitUntilBeClickable(subject);
        subject.click();
        subject.sendKeys(subj);
        return this;
    }

    public WriteLetterPage typeBody(String text) {
        log.info("Type letter text");
        waitUntilBeClickable(body);
        body.click();
        body.sendKeys(text);
        return this;
    }

    public WriteLetterPage clickSend() {
        log.info("Click Send button");
        waitUntilBeClickable(send).click();
        return this;
    }
}
