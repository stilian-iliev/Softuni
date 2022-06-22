package bg.softuni.musicdb.models;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "text")
    private String careerInformation;

    public Artist() {
    }

    public Artist(String name, String careerInformation) {
        this.name = name;
        this.careerInformation = careerInformation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
