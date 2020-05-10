package osva.springframework.simplecrud.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osva.springframework.simplecrud.models.Student;
import osva.springframework.simplecrud.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.listStudents();
    }

    @GetMapping("/student")
    public Student getStudent(@RequestParam(name = "registration") Integer registrationNumber) {
        return studentService.getStudentByRegistrationNumber(registrationNumber);
    }

    @PutMapping("/student/save")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveOrUpdateStudent(student);
    }
}
