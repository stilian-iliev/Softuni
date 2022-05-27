package bg.softuni.mobilele.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private UserRole role;
    private String imageUrl;
    private LocalDateTime created;
    private LocalDateTime modified;
}
