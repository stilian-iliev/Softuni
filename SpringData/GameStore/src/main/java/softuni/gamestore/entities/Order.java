package softuni.gamestore.entities;

import softuni.gamestore.entities.game.Game;
import softuni.gamestore.entities.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User buyer;

    @ManyToMany
    private Set<Game> products;

    public Order() {
        products = new HashSet<>();
    }

    public Order(User buyer) {
        this();
        this.buyer = buyer;
    }
}
