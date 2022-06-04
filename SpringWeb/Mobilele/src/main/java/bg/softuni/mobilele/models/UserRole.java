package bg.softuni.mobilele.models;

import bg.softuni.mobilele.models.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
