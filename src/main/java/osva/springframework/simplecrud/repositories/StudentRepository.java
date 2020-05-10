package osva.springframework.simplecrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import osva.springframework.simplecrud.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
