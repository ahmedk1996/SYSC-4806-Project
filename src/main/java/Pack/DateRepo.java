package Pack;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DateRepo extends CrudRepository<AvailabilityDate, String> {

    List<AvailabilityDate> findAll();
}
