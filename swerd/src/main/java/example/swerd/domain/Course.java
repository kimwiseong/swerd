package example.swerd.domain;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    @Column(
            name = "course_name"
    )
    private String name;
    @Column(
            name = "course_number"
    )
    private int number;
    @OneToMany(
            mappedBy = "course",
            cascade = {CascadeType.ALL}
    )
    private List<StudentCourse> studentCourses = new ArrayList();
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "instructor_id"
    )
    private Instructor instructor;
    @OneToMany(
            mappedBy = "course"
    )
    private List<Lecture> lectures = new ArrayList();

}

