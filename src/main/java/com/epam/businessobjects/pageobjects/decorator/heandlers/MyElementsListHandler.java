package com.epam.businessobjects.pageobjects.decorator.heandlers;

import com.epam.businessobjects.pageobjects.decorator.elements.AbstractElement;
import com.epam.businessobjects.pageobjects.decorator.elements.MyElementFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyElementsListHandler implements InvocationHandler {
    private final ElementLocator locator;
    private final Class type;
    private final MyElementFactory myElementFactory;

    <E extends AbstractElement> MyElementsListHandler(ElementLocator locator, Class<E> type) {
        this.locator = locator;
        this.type = type;
        this.myElementFactory = new MyElementFactory();
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        List<AbstractElement> elements = new ArrayList<>();
        for (WebElement element : locator.findElements())
            elements.add(myElementFactory.create(type, element));
        try {
            return method.invoke(elements, objects);
        } catch (InvocationTargetException var6) {
            throw var6.getCause();
        }
    }
}