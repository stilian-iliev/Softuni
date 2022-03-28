package softuni.exam.models.dto.ticket;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneNumberDto {
    @XmlElement(name = "register-number")
    private String registerNumber;

    public String getRegisterNumber() {
        return registerNumber;
    }
}
