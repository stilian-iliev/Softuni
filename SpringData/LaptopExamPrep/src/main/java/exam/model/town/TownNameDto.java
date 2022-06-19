package exam.model.town;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TownNameDto {
    @XmlElement
    private String name;

    public TownNameDto(String name) {
        this.name = name;
    }

    public TownNameDto() {
    }

    public String getName() {
        return name;
    }
}
