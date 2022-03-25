package _03_university_db;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @ManyToOne
    private Teacher teacher;

    @ManyToMany
    private Set<Student> students;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    private int credits;
}
