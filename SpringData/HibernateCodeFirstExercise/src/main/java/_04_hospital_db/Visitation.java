package _04_hospital_db;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "visitations")
public class Visitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String comment;

    @ManyToOne()
    private Patient patient;

    public Visitation() {}

    public Visitation(LocalDate date, String comment) {
        this.date = date;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
