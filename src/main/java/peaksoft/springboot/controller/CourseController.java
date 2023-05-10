package peaksoft.springboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.springboot.entity.Company;
import peaksoft.springboot.entity.Course;
import peaksoft.springboot.service.CompanyService;
import peaksoft.springboot.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final CompanyService companyService;


    @ModelAttribute("companyList")
    public List<Company> getCompanyList() {
        return companyService.getAllCompanies();
    }

    @GetMapping()
    public String getAllCourses(Model model) {
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("courses", courses);
        return "course/courses";

    }

    @GetMapping("/addCourse")
    public String addCourse(Model model) {
        model.addAttribute("course", new Course());
        return "course/addCourse";
    }

    @PostMapping("saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.addCourse(course.getCompanyId(), course);
        return "redirect:/courses";
    }

    @GetMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("updateCourse", course);
        return "course/updateCourse";
    }

    @PatchMapping("{id}")
    public String saveUpdateCourse(@PathVariable("id") Long id,@ModelAttribute("course") Course course) {
        courseService.updateCourse(course.getCompanyId(),id,course);
        return "redirect:/courses";
    }


    @DeleteMapping("/delete")
    public String deleteCourse(@RequestParam("id") Long id) {
        Course course = courseService.getCourseById(id);
        courseService.deleteCourse(course);
        return "redirect:/courses";
    }
}
