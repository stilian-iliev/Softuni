package bg.softuni.market.models.entities;

import bg.softuni.market.utils.InvalidArgumentException;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product extends BaseEntity{
    @Column(name = "best_before")
    private LocalDate bestBefore;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(String name, BigDecimal price, LocalDate bestBefore, Category category) {
        setName(name);
        setPrice(price);
        setBestBefore(bestBefore);
        setCategory(category);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 2) throw new InvalidArgumentException("Name must be minimum two characters!");
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price.signum() == -1) throw new InvalidArgumentException("Price must be positive!");
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f $", getName(), getPrice().doubleValue());
    }
}
