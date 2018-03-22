package com.epam.businessobjects.pageobjects;

import com.epam.businessobjects.pageobjects.decorator.elements.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends AbstractPage {
    private static final Logger log = Logger.getLogger(LetterPage.class);

    @FindBy(xpath = "//div[@role='button'][contains(@class, 'Wm')][div[contains(@class, 'Vd')]]")
    private Button deleteButton;

    public LetterPage clickDelete() {
        log.info("Delete Letter");
        waitUntilBeClickable(deleteButton).click();
        return this;
    }
}
