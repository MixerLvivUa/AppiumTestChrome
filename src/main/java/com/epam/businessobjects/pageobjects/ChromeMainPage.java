package com.epam.businessobjects.pageobjects;

import com.epam.businessobjects.pageobjects.decorator.elements.Button;
import com.epam.businessobjects.pageobjects.decorator.elements.InputField;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class ChromeMainPage extends AbstractPage {
    private static final Logger log = Logger.getLogger(ChromeMainPage.class);

    @FindBy(id = "com.android.chrome:id/tab_switcher_button")
    private Button tabSwitcher;

    @FindBy(id = "com.android.chrome:id/new_tab_button")
    private Button newTab;

    @FindBy(id = "com.android.chrome:id/search_box_text")
    private InputField searchBox;

    @FindBy(id = "com.android.chrome:id/url_bar")
    private InputField urlBar;


    public void openTabs() {
        waitUntilBeClickable(tabSwitcher).click();
    }

    public void createNewTab() {
        openTabs();
        waitUntilBeClickable(newTab).click();
    }

    public void searchOrOpenWebPage(String test) {
        waitUntilBeClickable(searchBox).click();
        urlBar.sendKeys(String.format("%s\n", test));
    }
}
