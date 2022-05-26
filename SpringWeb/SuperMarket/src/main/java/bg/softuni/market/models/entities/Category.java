package bg.softuni.market.models.entities;

import bg.softuni.market.utils.InvalidArgumentException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String name;

    public Category() {
    }

    public Category(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 2) throw new InvalidArgumentException("Name must be minimum two characters!");
        this.name = name;
    }
}
