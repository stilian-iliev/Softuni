package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.Model;
import bg.softuni.mobilele.models.enums.Engine;
import bg.softuni.mobilele.models.enums.Transmission;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AddOfferDto {
    @NotBlank
    private String model;
    @NotNull
    private Engine engine;

    @Positive
    @NotNull
    private int price;

    @Min(1900)
    @NotNull
    private int year;

    @Positive
    @NotNull
    private int mileage;

    @NotNull
    private Transmission transmission;

    @NotBlank
    private String imageUrl;

    @NotBlank
    private String description;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
