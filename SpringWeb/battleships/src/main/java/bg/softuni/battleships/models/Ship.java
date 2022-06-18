package bg.softuni.battleships.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int health;

    @Column(nullable = false)
    private int power;

    @Column(nullable = false)
    private LocalDate created;

    @ManyToOne(optional = false)
    private Category category;

    @ManyToOne(optional = false)
    private User user;
}
