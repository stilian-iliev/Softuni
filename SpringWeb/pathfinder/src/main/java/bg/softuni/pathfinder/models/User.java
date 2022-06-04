package bg.softuni.pathfinder.models;

import bg.softuni.pathfinder.models.enums.Level;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int age;

    private String fullName;

    private String password;

    @Column(unique = true, nullable = false)
    private String username;

    @ManyToMany
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    private Level level;
}
