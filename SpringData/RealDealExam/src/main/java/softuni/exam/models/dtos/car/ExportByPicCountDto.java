package softuni.exam.models.dtos.car;

import java.time.LocalDate;

public class ExportByPicCountDto {
    private String make;
    private String model;
    private int kilometers;
    private LocalDate dateOfRegistration;
    private long countOfPictures;

    public ExportByPicCountDto(String make, String model, int kilometers, LocalDate dateOfRegistration, long countOfPictures) {
        this.make = make;
        this.model = model;
        this.kilometers = kilometers;
        this.dateOfRegistration = dateOfRegistration;
        this.countOfPictures = countOfPictures;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getKilometers() {
        return kilometers;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public long getCountOfPictures() {
        return countOfPictures;
    }

    @Override
    public String toString() {
        return String.format("Car make - %s, model - %s\n" +
                "\tKilometers - %d\n" +
                "\tRegistered on - %s\n" +
                "\tNumber of pictures - %d",getMake(), getModel(), getKilometers(), getDateOfRegistration(), getCountOfPictures());
    }
}
