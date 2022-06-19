package softuni.exam.instagraphlite.models.dtos.picture;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PictureImportDto {
    @NotNull
    private String path;

    @Min(500)
    @Max(60000)
    private double size;

    public String getPath() {
        return path;
    }

    public double getSize() {
        return size;
    }
}
