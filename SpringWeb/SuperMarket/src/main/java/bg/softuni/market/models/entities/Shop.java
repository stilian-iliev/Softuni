package bg.softuni.market.models.entities;

import bg.softuni.market.utils.InvalidArgumentException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shops")
public class Shop extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String address;

    @Column
    private String name;

    @ManyToOne
    private Town town;

    @ManyToMany
    private List<Product> products;

    @OneToMany(mappedBy = "shop")
    private List<Seller> sellers;

    public Shop() {
    }

    public Shop(String address, String name, Town town) {
        setAddress(address);
        setName(name);
        setTown(town);
        products = new ArrayList<>();
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.length() < 2) throw new InvalidArgumentException("Address must be minimum two characters!");
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 2) throw new InvalidArgumentException("Name must be minimum two characters!");
        this.name = name;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
