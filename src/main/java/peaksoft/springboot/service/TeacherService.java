package peaksoft.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.springboot.entity.Course;
import peaksoft.springboot.entity.Group;
import peaksoft.springboot.entity.Student;
import peaksoft.springboot.entity.Teacher;
import peaksoft.springboot.repository.CourseRepository;
import peaksoft.springboot.repository.StudentRepository;
import peaksoft.springboot.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    @Autowired
    private final TeacherRepository teacherRepository;
    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final StudentRepository studentRepository;


    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Long companyId, Teacher teacher) {
        Teacher teacher1 = teacherRepository.findById(companyId).get();
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setLastName(teacher.getLastName());
        teacherRepository.save(teacher1);


    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).get();
    }

    public void updateTeacher(Long teacherId,Long courseId, Teacher teacher) {
    Course course=courseRepository.findById(courseId).get();
    Teacher teacher1=teacherRepository.findById(teacherId).get();
    teacher1.setFirstName(teacher.getFirstName());
    teacher1.setEmail(teacher.getEmail());
    teacher1.setLastName(teacher.getLastName());
    course.setTeacher(teacher1);
    teacher1.setCourse(course);
    teacherRepository.save(teacher1);

    }

    public void deleteTeacher(Teacher teacher) {
        teacherRepository.delete(teacher);
    }


//    public List<Student> getStudentsByCompany(Long teacherId) {
//        return studentDao.getStudentsByCompany(teacherId);
//    }
}
