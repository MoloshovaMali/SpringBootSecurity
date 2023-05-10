package peaksoft.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "duration_month")
    private String durationMonth;
    @Transient
    private Long companyId;
    @Transient
    private Long teacherId;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "courseList")
//    @JoinTable(
//            name = "groups_courses",
//            joinColumns = @JoinColumn(name = "courses_id"),
//            inverseJoinColumns = @JoinColumn(name = "groups_id")
//    )
    private List<Group> groupList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

}
