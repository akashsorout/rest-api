package in.co.bytehub.restapi.app.service.repo;

import in.co.bytehub.restapi.app.model.Topic;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("DB")
public interface TopicRepositoryJPA extends CrudRepository<Topic, Integer> {

}
