package com.epam.businessobjects.pageobjects;

import com.epam.businessobjects.pageobjects.decorator.elements.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class ChromeInitPage extends AbstractPage {
    private static final Logger log = Logger.getLogger(ChromeInitPage.class);

    @FindBy(id = "com.android.chrome:id/terms_accept")
    private Button accentAdnContinue;

    @FindBy(id = "com.android.chrome:id/negative_button")
    private Button noThanks;




    public void acceptAndContinue() {
        waitUntilBeClickable(accentAdnContinue).click();
    }
    public void noMailAutorize() {
        waitUntilBeClickable(noThanks).click();
    }

}
