package Pack;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoordinatorRepo extends CrudRepository<Coordinator, Integer> {

    List<Coordinator> findByName(String name);

}