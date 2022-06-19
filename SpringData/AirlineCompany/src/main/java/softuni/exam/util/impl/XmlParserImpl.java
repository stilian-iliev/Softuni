package softuni.exam.util.impl;

import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.util.List;

public class XmlParserImpl implements XmlParser {
    @Override
    public <E> List<E> parse(FileReader input, Class<E> clazz) throws JAXBException {
        return null;
    }
}
