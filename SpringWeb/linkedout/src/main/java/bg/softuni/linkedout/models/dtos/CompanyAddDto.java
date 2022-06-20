package bg.softuni.linkedout.models.dtos;

import bg.softuni.linkedout.validation.UniqueName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class CompanyAddDto {
    @NotNull
    @Length(min = 2, max = 10)
    @UniqueName
    private String name;
    @NotNull
    @Length(min = 2, max = 10)
    private String town;
    @NotNull
    @Length(min = 10)
    private String description;
    @NotNull
    @Positive
    private BigDecimal budget;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
