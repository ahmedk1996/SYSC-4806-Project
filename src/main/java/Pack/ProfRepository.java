package Pack;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfRepository extends CrudRepository<Prof, Integer> {
    List<Prof> findProfById(int id);


}
