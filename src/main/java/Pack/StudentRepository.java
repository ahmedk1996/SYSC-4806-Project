package Pack;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findByName(String name);
    List<Student> findByProjectId(int projectId);
    List<Student> findById(Student student);
}