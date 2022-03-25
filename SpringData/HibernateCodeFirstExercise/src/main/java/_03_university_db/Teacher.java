package _03_university_db;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "teachers")
public class Teacher extends Person{

    private String email;

    @Column(name = "salary_per_hour")
    private BigDecimal salaryPerHour;

    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;

    public Teacher() {}
}
