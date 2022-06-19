package softuni.exam.util;

import javax.xml.bind.JAXBException;
import java.io.FileReader;
import java.util.List;

public interface XmlParser {
    <E> List<E> parse(FileReader input, Class<E> clazz) throws JAXBException;
}
