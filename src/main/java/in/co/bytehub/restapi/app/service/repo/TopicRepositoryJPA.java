package in.co.bytehub.restapi.app.service.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.co.bytehub.restapi.app.model.Topic;

@Repository
public interface TopicRepositoryJPA extends CrudRepository<Topic, Integer> {

}
