package com.epam.testdata;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "userData")
public class TestData {
    @XmlElement(name = "userMail")
    private String userMail;
    @XmlElement(name = "userPassword")
    private String userPassword;
    @XmlElement(name = "elementsCount")
    private int elementsCount;

    public String getUserMail() {
        return userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public int getElementsCount() {
        return elementsCount;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", userMail, userPassword);
    }
}
