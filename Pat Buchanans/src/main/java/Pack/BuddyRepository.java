package Pack;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BuddyRepository extends CrudRepository<JBuddy, Integer> {

    List<JBuddy> findByName(String firstName);
}
