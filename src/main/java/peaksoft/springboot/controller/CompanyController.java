package peaksoft.springboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.springboot.entity.Company;
import peaksoft.springboot.entity.Student;
import peaksoft.springboot.service.CompanyService;
import peaksoft.springboot.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    private final StudentService studentService;



    @GetMapping()
    public String getAllCompanies(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "company/companies";

    }

    @GetMapping("/addCompany")
    public String addCompany(Model model) {
        model.addAttribute("company", new Company());
        return "company/addCompany";
    }

    @PostMapping("saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.addCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/update/{id}")
    public String updateCompany(@PathVariable("id") Long id, Model model) {
        Company company = companyService.getCompanyById(id);
        model.addAttribute("updateCompany", company);
        return "company/updateCompany";
    }

    @PatchMapping("{id}")
    public String saveUpdateCompany(@PathVariable("id") Long id, @ModelAttribute("company") Company company) {
        companyService.updateCompany(id, company);
        return "redirect:/companies";
    }

    @DeleteMapping("/delete")
    public String deleteCompany(@RequestParam("id") Long id) {
        Company company = companyService.getCompanyById(id);
        companyService.deleteCompany(company);
        return "redirect:/companies";
    }

//    @GetMapping("/students/{companyId}")
//    public String getStudentByCompanyId(@PathVariable("companyId") Long companyId, Model model) {
//        List<Student> studentsList = studentService.getStudentsByCompany(companyId);
//        model.addAttribute("studentsList", studentsList);
//        model.addAttribute("count", studentsList.size());
//        return "company/students";
//    }


}
