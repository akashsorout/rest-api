package restapiboot.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restapiboot.app.model.Topic;
import restapiboot.app.service.repo.TopicRepositoryJPA;

@Service
public class TopicServiceWithDB {
	
	@Autowired
	public TopicRepositoryJPA repo;
	
	public Iterable<Topic> getAllTopics(){
		return repo.findAll();
	}
	
	
	public Topic getTopic(int id){
		
		return repo.findById(id).get();
	}
	
	public void addTopic(Topic topic) {
		repo.save(topic);
	}


	public void updateTopic(Topic topic, int id) {
		repo.save(topic);
	}


	public void deleteTopic(int id) {
		repo.deleteById(id);
	}
	
}
