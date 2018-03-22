package com.epam.businessobjects.pageobjects.decorator.elements;

import com.epam.businessobjects.pageobjects.decorator.elements.actions.Click;
import org.openqa.selenium.WebElement;

public class CheckBox extends AbstractElement implements Click {
    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        webElement.click();
    }

    public void check() {
        if (!webElement.getAttribute("aria-checked").equals("true"))
            webElement.click();
    }

    public void unCheck() {
        if (!webElement.getAttribute("aria-checked").equals("false"))
            webElement.click();
    }
}
