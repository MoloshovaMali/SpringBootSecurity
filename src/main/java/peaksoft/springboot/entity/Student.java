package peaksoft.springboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    private String email;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "study_format")
    @Enumerated
    private StudyFormat studyFormat;


    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.REFRESH})
    @JoinColumn(name = "group_id")
    private Group group;
    @Transient
    private Long groupId;


}
