package peaksoft.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.springboot.entity.Company;
import peaksoft.springboot.entity.Course;
import peaksoft.springboot.entity.Group;
import peaksoft.springboot.entity.Student;
import peaksoft.springboot.repository.GroupRepository;
import peaksoft.springboot.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final GroupRepository groupRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Long groupId, Student student) {
//      Group group=groupRepository.findById(groupId).get();
//      List<Group>groups=new ArrayList<>();
//      groups.add(group);
//      List<Student>students=new ArrayList<>();
//      students.add(student);
//      group.setStudentList(students);
//      studentRepository.save(student);
        Group group=groupRepository.findById(groupId).get();
        student.setGroup(group);
        studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public void updateStudent(Long studentId,Long groupId, Student student) {
        Group group=groupRepository.findById(groupId).get();
        Student student1 = studentRepository.findById(studentId).get();
        student1.setFirstName(student.getFirstName());
        student1.setEmail(student.getEmail());
        student1.setLastName(student.getLastName());
        student1.setStudyFormat(student.getStudyFormat());
        List<Student>students=new ArrayList<>();
        students.add(student1);
        group.setStudentList(students);
        student1.setGroup(group);
        studentRepository.save(student1);
    }

    public void deleteStudent(Student student) {
    studentRepository.delete(student);
    }

//    public List<Student> getStudentsByCompany(Long companyId) {
//        return studentRepository.getStudentByCompany(companyId);
//    }

//    public List<Student> getStudentByName(String name) {
//        return studentRepository.getStudentByName(name);
//    }
}
