package com.epam.businessobjects.pageobjects.decorator.elements;

import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

public class MyElementFactory {
    public <E extends AbstractElement> E create(final Class<E> elementClass, final WebElement wrappedElement) {
        try {
            return elementClass
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}