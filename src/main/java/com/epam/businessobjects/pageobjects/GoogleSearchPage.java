package com.epam.businessobjects.pageobjects;

import com.epam.businessobjects.pageobjects.decorator.elements.Button;
import com.epam.businessobjects.pageobjects.decorator.elements.InputField;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends AbstractPage {
    private static final Logger log = Logger.getLogger(GoogleSearchPage.class);

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.widget.EditText")
    private InputField searchInput;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[3]/android.view.View[1]/android.view.View/android.view.View[2]/android.widget.EditText")
    private InputField searchResultInput;

    @FindBy(id = "cnt")
    private Button focus;

    public void googleIt(String text) {
        waitUntilBeClickable(searchInput).click();
        searchInput.sendKeys(String.format("%s\n", text));
    }

    public boolean isResultContainsText(String text) {
        waitUntilBeClickable(focus).click();
        return text.equals(searchResultInput.getText());
    }
}
