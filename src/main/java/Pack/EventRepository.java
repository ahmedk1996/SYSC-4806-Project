package Pack;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {

    List<Event> findByDescription(String description);
}
