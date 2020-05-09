package osva.springframework.simplecrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osva.springframework.simplecrud.entities.Student;
import osva.springframework.simplecrud.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student getStudentById(Integer registrationNumber) {
        return studentRepository.getStudentByRegistrationNumber(registrationNumber);
    }
}
