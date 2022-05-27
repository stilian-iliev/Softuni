package bg.softuni.mobilele.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    private String name;
    private LocalDateTime created;
    private LocalDateTime modified;


}
