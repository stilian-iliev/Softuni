package _03_university_db;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "students")
public class Student extends Person{

    @Column(name = "average_grade")
    private double averageGrade;

    private boolean attendance;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

    public Student() {}
}
