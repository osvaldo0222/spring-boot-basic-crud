package osva.springframework.simplecrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import osva.springframework.simplecrud.models.Student;
import osva.springframework.simplecrud.services.StudentService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/", ""})
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = {"/list", "", "/"})
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.listStudents());
        return "/students/ListStudents";
    }

    @RequestMapping("/view/{registrationNumber}")
    public String listStudents(@PathVariable Integer registrationNumber, Model model) {
        model.addAttribute("student", studentService.getStudentByRegistrationNumber(registrationNumber));
        return "/students/ViewStudent";
    }

    @RequestMapping("/edit/{registrationNumber}")
    public String editStudents(@PathVariable Integer registrationNumber, Model model) {
        model.addAttribute("student", studentService.getStudentByRegistrationNumber(registrationNumber));
        return "/students/FormStudent";
    }

    @RequestMapping("/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "/students/FormStudent";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/students/FormStudent";
        }
        Student savedStudent = studentService.saveOrUpdateStudent(student);
        return "redirect:/view/" + savedStudent.getRegistrationNumber();
    }

    @RequestMapping("/delete/{registrationNumber}")
    public String deleteStudent(@PathVariable Integer registrationNumber) {
        studentService.deleteStudent(registrationNumber);
        return "redirect:/list";
    }
}
