package restapiboot.app.service.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import restapiboot.app.model.Topic;

@Repository
public interface TopicRepositoryJPA extends CrudRepository<Topic, Integer> {

}
