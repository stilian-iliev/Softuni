package softuni.exam.models.dto.town;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Positive;

public class TownImportDto {
    @Length(min = 2)
    private String name;
    @Positive
    private int population;
    private String guide;

    public TownImportDto() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getGuide() {
        return guide;
    }
}
