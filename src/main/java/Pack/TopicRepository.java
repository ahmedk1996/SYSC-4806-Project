package Pack;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    Topic findByTopicName(String topicName);
    Topic findByProfID(int profID);
    Topic findById(int topicID);
}
