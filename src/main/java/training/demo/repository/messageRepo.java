package training.demo.repository;

import org.springframework.data.repository.CrudRepository;
import training.demo.domain.message;

import java.util.List;

public interface messageRepo extends CrudRepository<message, Long> {

    List<message> findByTag(String tag);
}
