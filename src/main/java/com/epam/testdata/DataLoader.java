package com.epam.testdata;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Objects;

public class DataLoader {
    private static final Logger log = Logger.getLogger(DataLoader.class);

    public static <E> E loadXML(String fileURL, Class<E> dataType) throws JAXBException {
        File file = new File(fileURL);
        JAXBContext jc = JAXBContext.newInstance(dataType);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (E) unmarshaller.unmarshal(file);
    }

    public static <E> E loadXMLFromResources(String fileName, Class<E> datatype) throws JAXBException {
        return loadXML(Objects.requireNonNull(DataLoader.class.getClassLoader().getResource(fileName)).getPath(), datatype);
    }
}
