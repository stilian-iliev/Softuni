package softuni.exam.models.dto.plane;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plane")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneImportDto {
    @XmlElement(name = "register-number")
    @Size(min = 5)
    private String registerNumber;

    @XmlElement(name = "capacity")
    @Positive
    private int capacity;

    @XmlElement(name = "airline")
    @Size(min = 2)
    private String airline;

    public String getRegisterNumber() {
        return registerNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getAirline() {
        return airline;
    }
}
