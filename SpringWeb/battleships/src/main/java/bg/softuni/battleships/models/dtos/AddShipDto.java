package bg.softuni.battleships.models.dtos;

import bg.softuni.battleships.models.Category;
import bg.softuni.battleships.models.enums.ShipType;
import bg.softuni.battleships.validation.UniqueName;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class AddShipDto {
    @NotBlank
    @Length(min = 2, max = 10)
    @UniqueName
    private String name;
    @Positive
    @NotNull
    private int power;
    @Positive
    @NotNull
    private int health;
    @PastOrPresent
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;
    @NotNull
    private ShipType category;

    public AddShipDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public ShipType getCategory() {
        return category;
    }

    public void setCategory(ShipType category) {
        this.category = category;
    }
}
