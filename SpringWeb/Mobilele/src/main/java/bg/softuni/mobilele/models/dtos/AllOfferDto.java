package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.Offer;

import java.math.BigDecimal;

public class AllOfferDto {
    private long id;
    private String brand;
    private String model;
    private long mileage;
    private BigDecimal price;
    private String engine;
    private String transmission;
    private String imageUrl;
    private int year;

    public AllOfferDto(Offer offer) {
        this.id = offer.getId();
        this.brand = offer.getModel().getBrand().getName();
        this.model = offer.getModel().getName();
        this.mileage = offer.getMileage();
        this.price =offer.getPrice();
        this.engine = offer.getEngine().name();
        this.transmission = offer.getTransmission().name();
        this.imageUrl = offer.getImageUrl();
        this.year = offer.getYear();
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public long getMileage() {
        return mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getEngine() {
        return engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s", getYear(), getBrand(), getModel());
    }
}
