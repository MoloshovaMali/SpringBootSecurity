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
    public void addTeacher(Long courseId, Teacher teacher) {
        Course course=courseRepository.findById(courseId).get();
        List<Course>courses=new ArrayList<>();
        courses.add(course);
        List<Teacher>teachers=new ArrayList<>();
        teachers.add(teacher);
        course.setTeacher(teachers);
        teacherRepository.save(teacher);

    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).get();
    }

    public void updateTeacher(Long teacherId, Teacher teacher) {

        Teacher teacher1=teacherRepository.findById(teacherId).get();
        teacher1.setFirstName(teacher1.getFirstName());
        teacher1.setEmail(teacher1.getEmail());
        teacher1.setLastName(teacher1.getLastName());
        Student student=studentRepository.findById(teacherId).get();
        List<Teacher>teachers=new ArrayList<>();
        teachers.add(teacher1);

    }

    public void deleteTeacher(Teacher teacher) {
       teacherRepository.delete(teacher);
    }


//    public List<Student> getStudentsByCompany(Long teacherId) {
//        return studentDao.getStudentsByCompany(teacherId);
//    }
}
