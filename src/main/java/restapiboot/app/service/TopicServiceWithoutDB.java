package restapiboot.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import restapiboot.app.model.Topic;

@Profile("IN_MEMORY")
@Service
public class TopicServiceWithoutDB implements TopicService {

	private List<Topic> lstTopics = new ArrayList<>(Arrays.asList(new Topic(1, "Java Core"), new Topic(2, "Lucene"),
			new Topic(3, "Jax-Rs"), new Topic(4, "Hibernate")));

	@Override
	public List<Topic> getAllTopics() {
		return lstTopics;
	}

	@Override
	public Topic getTopic(int id) {

		Topic obj = null;

		for (Topic topic : lstTopics) {
			if (topic.getId() == id) {
				obj = topic;
				break;
			}
		}

		return obj;
	}

	@Override
	public void addTopic(Topic topic) {
		lstTopics.add(topic);
	}

	@Override
	public void updateTopic(Topic topic, int id) {

		for (int i = 0; i < lstTopics.size(); i++) {
			if (lstTopics.get(i).getId() == id) {
				lstTopics.set(i, topic);
				break;
			}
		}
	}

	@Override
	public void deleteTopic(int id) {

		for (int i = 0; i < lstTopics.size(); i++) {
			if (lstTopics.get(i).getId() == id) {
				lstTopics.remove(i);
				break;
			}
		}
	}

}
