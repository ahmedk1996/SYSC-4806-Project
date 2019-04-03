package Pack;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    List<Topic> findByDescription(String description);
    List<Topic> findByProfID(int profID);
    Topic findByTopicName(String topicName);
}
