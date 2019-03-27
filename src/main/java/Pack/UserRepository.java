package Pack;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String username);


    User findByUsername(String username);
}

//public interface UserRepository extends CrudRepository<Student, Integer> {
//    Object findByName(String username);
//
//    //Useer findByName(String name);
//
//   // List<Student> findById(Student student);
//
//    //User findByUsername(String username);
//}
