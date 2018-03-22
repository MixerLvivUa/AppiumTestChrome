package com.epam.businessobjects.pageobjects.decorator.heandlers;

import com.epam.businessobjects.pageobjects.decorator.elements.AbstractElement;
import com.epam.businessobjects.pageobjects.decorator.elements.MyElementFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.List;

public class MyFieldDecorator extends DefaultFieldDecorator {
    private MyElementFactory elementFactory = new MyElementFactory();

    MyFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (AbstractElement.class.isAssignableFrom(field.getType())) {
            return decorateElement(loader, field);
        }
        if (List.class.isAssignableFrom(field.getType()) && AbstractElement.class.isAssignableFrom((Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0])) {
            return decorateElements(loader, field);
        }
        return super.decorate(loader, field);
    }

    private Object decorateElement(final ClassLoader loader, final Field field) {
        return elementFactory.create((Class<? extends AbstractElement>) field.getType(), this.proxyForLocator(loader, this.factory.createLocator(field)));
    }

    private Object decorateElements(final ClassLoader loader, final Field field) {
        return this.proxyMyForListLocator(loader, this.factory.createLocator(field), (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]);
    }

    private List proxyMyForListLocator(ClassLoader loader, ElementLocator locator, Class type) {
        InvocationHandler handler = new MyElementsListHandler(locator, type);
        return (List) Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
    }
}