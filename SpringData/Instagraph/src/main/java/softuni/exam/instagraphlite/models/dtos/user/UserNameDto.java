package softuni.exam.instagraphlite.models.dtos.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserNameDto {
    @XmlElement
    private String username;

    public String getUsername() {
        return username;
    }
}
