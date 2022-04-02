package softuni.exam.models.entity;

import softuni.exam.models.enums.ApartmentType;

import javax.persistence.*;

@Entity
@Table(name = "apartments")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "area_type")
    @Enumerated(EnumType.STRING)
    private ApartmentType apartmentType;

    @Column(nullable = false)
    private double area;

    @ManyToOne(optional = false)
    private Town town;

    public Apartment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
