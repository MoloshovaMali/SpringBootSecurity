package peaksoft.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.springboot.entity.Course;
import peaksoft.springboot.entity.Group;
import peaksoft.springboot.entity.Student;
import peaksoft.springboot.repository.CourseRepository;
import peaksoft.springboot.repository.GroupRepository;
import peaksoft.springboot.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class GroupService  {
    @Autowired
    private final GroupRepository groupRepository;
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final CourseRepository courseRepository;


    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public void addGroup(Long courseId, Group group) {
     Course course=courseRepository.findById(courseId).get();
     List<Course>courses=new ArrayList<>();
     courses.add(course);
     List<Group>groups=new ArrayList<>();
     groups.add(group);
     course.setGroupList(groups);
     groupRepository.save(group);
    }

    public Group getGroupById(Long id) {
        return groupRepository.findById(id).get();
    }

    public void updateGroup(Long groupId,Long courseId, Group group) {
        Group group1 = groupRepository.findById(groupId).get();
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setDateOfFinish(group.getDateOfFinish());
        Course course = courseRepository.findById(courseId).get();
        List<Group> groups = new ArrayList<>();
        groups.add(group1);
        course.setGroupList(groups);
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        group1.setCourseList(courses);
        groupRepository.save(group1);
    }

    public void deleteGroup(Group group) {
        groupRepository.delete(group);
    }


//    public List<Student> getStudentByName(String name) {
//        return studentRepository.findBy(name).get();
//    }
}

