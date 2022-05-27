package bg.softuni.mobilele.models;

import bg.softuni.mobilele.models.enums.Role;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity{
    private Role role;
}
