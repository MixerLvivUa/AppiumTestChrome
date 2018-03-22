package com.epam.businessobjects.pageobjects.decorator.elements;

import com.epam.businessobjects.pageobjects.decorator.elements.actions.Click;
import com.epam.businessobjects.pageobjects.decorator.elements.actions.SendKeys;
import org.openqa.selenium.WebElement;

public class InputField extends AbstractElement implements SendKeys, Click {
    public InputField(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(CharSequence... var1) {
        webElement.sendKeys(var1);
    }

    public String getValue() {
        return webElement.getAttribute("value");
    }

    @Override
    public void click() {
        webElement.click();
    }
}
