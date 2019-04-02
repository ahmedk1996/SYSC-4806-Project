package Pack;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    List<Topic> findByTopicName(String topicName);
    List<Topic> findByProfID(int profID);
}
