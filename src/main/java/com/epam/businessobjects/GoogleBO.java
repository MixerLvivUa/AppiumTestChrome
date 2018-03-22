package com.epam.businessobjects;

import com.epam.businessobjects.pageobjects.GoogleSearchPage;

public class GoogleBO {
    public void googleIt(String text) {
        new GoogleSearchPage().googleIt(text);
    }
    public boolean isResultContainsText(String text){
        return new GoogleSearchPage().isResultContainsText(text);
    }
}
