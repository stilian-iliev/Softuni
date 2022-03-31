package softuni.exam.models.dtos.picture;

import javax.validation.constraints.Size;

public class PictureImportDto {
    @Size(min = 3, max = 19)
    private String name;

    private String dateAndTime;

    private int car;

    public String getName() {
        return name;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public int getCar() {
        return car;
    }
}
