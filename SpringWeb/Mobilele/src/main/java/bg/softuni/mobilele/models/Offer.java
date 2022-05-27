package bg.softuni.mobilele.models;

import bg.softuni.mobilele.models.enums.Engine;
import bg.softuni.mobilele.models.enums.Transmission;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{
    @Column(columnDefinition = "TEXT")
    private String description;

    private Engine engine;

    private String imageUrl;

    private int mileage;

    private BigDecimal price;

    private Transmission transmission;

    private int year;

    private LocalDateTime created;
    private LocalDateTime modified;

    private Model model;
    private User seller;
}
