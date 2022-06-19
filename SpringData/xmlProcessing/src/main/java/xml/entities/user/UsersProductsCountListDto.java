package xml.entities.user;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersProductsCountListDto {
    @XmlAttribute(name = "count")
    private int count;

    @XmlElement(name = "user")
    private List<UserProductsDto> users;

    public UsersProductsCountListDto() {
    }

    public UsersProductsCountListDto(List<UserProductsDto> users) {
        this.users = users;
        count = users.size();
    }
}
