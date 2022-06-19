package entities;

import annotataions.Column;
import annotataions.Entity;
import annotataions.Id;

import java.time.LocalDate;

@Entity(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private int age;

    @Column(name = "registration")
    private LocalDate registration;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getRegistration() {
        return registration;
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
        this.registration = LocalDate.now();
    }

}
