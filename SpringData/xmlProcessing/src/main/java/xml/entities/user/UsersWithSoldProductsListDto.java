package xml.entities.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithSoldProductsListDto {
    @XmlElement(name = "user")
    List<UserWithSoldProductsDto> users;

    public UsersWithSoldProductsListDto() {}

    public UsersWithSoldProductsListDto(List<UserWithSoldProductsDto> users) {
        this.users = users;
    }

    public void setUsers(List<UserWithSoldProductsDto> users) {
        this.users = users;
    }
}
