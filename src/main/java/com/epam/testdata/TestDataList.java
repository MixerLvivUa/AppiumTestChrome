package com.epam.testdata;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "usersData")
public class TestDataList {
    @XmlElement(name = "userData")
    private List<TestData> testDataList;

    public TestDataList() {
        testDataList = new ArrayList<>();
    }

    public List<TestData> getTestDataList() {
        return testDataList;
    }
}
