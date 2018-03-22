package com.epam.businessobjects.pageobjects.decorator.elements;

import com.epam.businessobjects.pageobjects.decorator.elements.actions.Click;
import org.openqa.selenium.WebElement;

public class Button extends AbstractElement implements Click {

    public Button(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        webElement.click();
    }
}
