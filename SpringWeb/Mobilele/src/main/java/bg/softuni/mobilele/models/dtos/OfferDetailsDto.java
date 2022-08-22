package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.Offer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OfferDetailsDto {
    private String brand;
    private String model;
    private int year;
    private long mileage;
    private BigDecimal price;
    private String engine;
    private String transmission;
    private String seller;
    private String imageUrl;
    private LocalDateTime created;

    public OfferDetailsDto(Offer offer) {
        this.brand = offer.getModel().getBrand().getName();
        this.model = offer.getModel().getName();
        this.year = offer.getYear();
        this.mileage = offer.getMileage();
        this.price = offer.getPrice();
        this.engine = offer.getEngine().name();
        this.transmission = offer.getTransmission().name();
        this.seller = offer.getSeller().getFirstName() + ' ' + offer.getSeller().getLastName();
        this.imageUrl = offer.getImageUrl();
        this.created = offer.getCreated();
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
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

    public String getSeller() {
        return seller;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s", getYear(), getBrand(), getModel());
    }
}
