package peaksoft.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.springboot.entity.Group;
import peaksoft.springboot.entity.Student;
import peaksoft.springboot.service.GroupService;
import peaksoft.springboot.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;
    private final GroupService groupService;


    @Autowired
    public StudentController(StudentService service, GroupService groupService) {
        this.service = service;
        this.groupService = groupService;
    }

    @ModelAttribute("groupList")
    public List<Group> groupList() {
        return groupService.getAllGroups();
    }

    @GetMapping()
    public String getAllStudents(Model model) {
        List<Student> students = service.getAllStudents();
        model.addAttribute("students", students);
        return "student/students";

    }

    @GetMapping("/addStudent")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student/addStudent";
    }

    @PostMapping("saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.addStudent(student.getGroupId(), student);
        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, Model model) {
        Student student = service.getStudentById(id);
        model.addAttribute("updateStudent", student);
        return "student/updateStudent";
    }

    @PatchMapping("{id}")
    public String saveUpdateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        service.updateStudent(id,student.getGroupId(), student);
        return "redirect:/students";
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") Long id) {
        Student student = service.getStudentById(id);
        service.deleteStudent(student);
        return "redirect:/students";
    }
}
