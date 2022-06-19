package bg.softuni.pathfinder.models;

import bg.softuni.pathfinder.models.enums.RoleName;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private RoleName role;


}
