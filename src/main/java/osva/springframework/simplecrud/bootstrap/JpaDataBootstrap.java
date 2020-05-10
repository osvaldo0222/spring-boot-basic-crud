package osva.springframework.simplecrud.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import osva.springframework.simplecrud.models.Student;
import osva.springframework.simplecrud.services.StudentService;

@Component
public class JpaDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadStudents();
    }

    private void loadStudents() {
        for (int i = 0;i<8;i++) {
            Student student = new Student();
            student.setRegistrationNumber(2016100 * 10 + i);
            student.setName("Student ");
            student.setLastName(String.valueOf(i + 1));
            student.setPhone("809-678-123" + i);

            studentService.saveOrUpdateStudent(student);
        }
    }
}
