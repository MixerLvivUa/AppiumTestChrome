package com.epam.businessobjects;

import com.epam.businessobjects.pageobjects.ChromeInitPage;
import com.epam.businessobjects.pageobjects.ChromeMainPage;

public class ChromeBO {

    public void startChrome() {
        ChromeInitPage chromeInitPage = new ChromeInitPage();
        chromeInitPage.acceptAndContinue();
        chromeInitPage.noMailAutorize();
    }

    public void createNewTabAndOpenPage(String url) {
        ChromeMainPage chromeMainPage = new ChromeMainPage();
        chromeMainPage.createNewTab();
        chromeMainPage.searchOrOpenWebPage(url);
    }
}
