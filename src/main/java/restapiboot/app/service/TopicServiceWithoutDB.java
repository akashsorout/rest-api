package restapiboot.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import restapiboot.app.model.Topic;

@Service
public class TopicServiceWithoutDB {

	private List<Topic> lstTopics = new ArrayList<>(Arrays.asList(new Topic(1,"Java Core"),
			new Topic(2,"Lucene"),
			new Topic(3,"Jax-Rs"),
			new Topic(4,"Hibernate"))); 

	
	public List<Topic> getAllTopics(){
		return lstTopics;
	}
	
	
	public Topic getTopic(int id){
		
		Topic obj = null;
		
		for (Topic topic : lstTopics) {
			if(topic.getId()==id)
				{obj= topic; break;}
		}
		
		return obj;
	}
	
	public void addTopic(Topic topic) {
		lstTopics.add(topic);
	}


	public void updateTopic(Topic topic, int id) {
		
		for(int i=0;i<lstTopics.size();i++) {
			if(lstTopics.get(i).getId()==id) {
				lstTopics.set(i, topic);break;
			}
		}
	}


	public void deleteTopic(int id) {
		
		for(int i=0;i<lstTopics.size();i++) {
			if(lstTopics.get(i).getId()==id) {
				lstTopics.remove(i);break;
			}
		}
	}
	
}
