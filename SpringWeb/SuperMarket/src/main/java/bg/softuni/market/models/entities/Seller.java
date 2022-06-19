package bg.softuni.market.models.entities;

import bg.softuni.market.utils.InvalidArgumentException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "sellers")
public class Seller extends BaseEntity{
    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private BigDecimal salary;

    @ManyToOne
    private Shop shop;

    @ManyToOne
    private Seller manager;

    public Seller() {
    }

    public Seller(String firstName, String lastName, Integer age, BigDecimal salary, Shop shop) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
        setShop(shop);
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 2) throw new InvalidArgumentException("First name must be minimum two characters!");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 2) throw new InvalidArgumentException("Last name must be minimum two characters!");
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age < 18) throw new InvalidArgumentException("Seller must be at least 18 years old!");
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        if (salary.signum() == -1) throw new InvalidArgumentException("Salary must be a positive number");
        this.salary = salary;
    }

    public Seller getManager() {
        return manager;
    }

    public void setManager(Seller manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
