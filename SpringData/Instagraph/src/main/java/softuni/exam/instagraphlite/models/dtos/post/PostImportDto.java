package softuni.exam.instagraphlite.models.dtos.post;

import org.hibernate.validator.constraints.Length;
import softuni.exam.instagraphlite.models.dtos.picture.PicturePathDto;
import softuni.exam.instagraphlite.models.dtos.user.UserNameDto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportDto {
    @XmlElement
    @NotNull
    @Length(min = 21)
    private String caption;

    @XmlElement
    private UserNameDto user;

    @XmlElement
    private PicturePathDto picture;

    public String getCaption() {
        return caption;
    }

    public UserNameDto getUser() {
        return user;
    }

    public PicturePathDto getPicture() {
        return picture;
    }
}
