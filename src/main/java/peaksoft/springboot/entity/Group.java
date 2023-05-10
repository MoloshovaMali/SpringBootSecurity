package peaksoft.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "date_of_start")
    private String dateOfStart;
    @Column(name = "date_of_finish")
    private String dateOfFinish;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "groups_courses",
            joinColumns = @JoinColumn(name = "groups_id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id")
    )
    private List<Course> courseList;


    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "group")
    private List<Student> studentList;

    @Transient
    private Long CourseId;


}

