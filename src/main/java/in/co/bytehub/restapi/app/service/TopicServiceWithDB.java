package in.co.bytehub.restapi.app.service;

import javax.transaction.Transactional;

import in.co.bytehub.restapi.app.model.Topic;
import in.co.bytehub.restapi.app.repo.TopicRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("DB")
@Service
@Transactional
public class TopicServiceWithDB implements TopicService {

	@Autowired
	public TopicRepositoryJPA repo;

	/* (non-Javadoc)
	 * @see restapiboot.app.service.TopicService#getAllTopics()
	 */
	@Override
	public Iterable<Topic> getAllTopics(){
		return repo.findAll();
	}


	/* (non-Javadoc)
	 * @see restapiboot.app.service.TopicService#getTopic(int)
	 */
	@Override
	public Topic getTopic(int id){

		Topic topic = repo.findById(id).get();
		System.out.println("topic.getName() = " + topic.getName());
		System.out.println("topic.getTeachers() = " + topic.getTeachers());
		System.out.println("topic.getChapters() = " + topic.getChapters());
        topic.setName(topic.getName() + "!");
		return topic;
	}

	/* (non-Javadoc)
	 * @see restapiboot.app.service.TopicService#addTopic(restapiboot.app.model.Topic)
	 */
	@Override
	public void addTopic(Topic topic) {
		repo.save(topic);
	}


	/* (non-Javadoc)
	 * @see restapiboot.app.service.TopicService#updateTopic(restapiboot.app.model.Topic, int)
	 */
	@Override
	public void updateTopic(Topic topic, int id) {
		repo.save(topic);
	}


	/* (non-Javadoc)
	 * @see restapiboot.app.service.TopicService#deleteTopic(int)
	 */
	@Override
	public void deleteTopic(int id) {
		repo.deleteById(id);
	}

}
