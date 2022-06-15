package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.Model;
import bg.softuni.mobilele.models.enums.Engine;
import bg.softuni.mobilele.models.enums.Transmission;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddOfferDto {
    private String model;
    @NotNull
    private Engine engine;

    @NotNull
    private Transmission transmission;

    @NotBlank
    private String imageUrl;

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


}
