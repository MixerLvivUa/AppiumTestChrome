package com.epam.testdata;

import java.util.List;

public class DataProviderTransformer {
    public static Object[][] transformListToObjects(List<?> list) {
        Object[][] res = new Object[list.size()][1];
        for (int i = 0; i < list.size(); i++)
            res[i][0] = list.get(i);
        return res;
    }
}