package com.epam.businessobjects.pageobjects.decorator.elements;

import org.openqa.selenium.WebElement;

public abstract class AbstractElement {
    protected WebElement webElement;

    public AbstractElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public String getAttribute(String s) {
        return webElement.getAttribute(s);
    }

    public WebElement getWebElement() {
        return webElement;
    }
}
