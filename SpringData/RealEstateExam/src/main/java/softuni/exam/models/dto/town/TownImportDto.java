package softuni.exam.models.dto.town;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TownImportDto {
    @Size(min = 2)
    private String townName;

    @Positive
    private int population;

    public String getTownName() {
        return townName;
    }

    public int getPopulation() {
        return population;
    }
}
