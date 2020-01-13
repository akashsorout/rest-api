package in.co.bytehub.restapi.app.service;

import in.co.bytehub.restapi.app.model.Topic;

public interface TopicService {

	Iterable<Topic> getAllTopics();

	Topic getTopic(int id);

	void addTopic(Topic topic);

	void updateTopic(Topic topic, int id);

	void deleteTopic(int id);

}