package bg.softuni.mobilele.models;

import bg.softuni.mobilele.models.enums.Category;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "models")
public class Model extends BaseEntity{
    private String name;
    private Category category;
    private String imageUrl;
    private int startYear;
    private int endYear;
    private LocalDateTime created;
    private LocalDateTime modified;
    private Brand brand;
}
