package peaksoft.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.springboot.entity.Company;
import peaksoft.springboot.entity.Course;
import peaksoft.springboot.repository.CompanyRepository;
import peaksoft.springboot.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final CompanyRepository companyRepository;


    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }


    public void addCourse(Long companyId, Course course) {
        Company company=companyRepository.findById(companyId).get();
        course.setCompany(company);
        courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

    public void updateCourse(Long companyId,Long courseId, Course course) {
        Course course1 = courseRepository.findById(courseId).get();
        course1.setCourseName(course.getCourseName());
        course1.setDurationMonth(course.getDurationMonth());
        Company company = companyRepository.findById(companyId).get();
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        company.setCourses(courses);
        course1.setCompany(company);
        courseRepository.save(course1);    }

    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }

}

