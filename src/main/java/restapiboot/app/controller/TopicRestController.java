package restapiboot.app.controller;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import restapiboot.app.customexception.ElementNotFound;
import restapiboot.app.model.Topic;
import restapiboot.app.service.TopicServiceWithDB;
import restapiboot.app.service.TopicServiceWithoutDB;

@RestController
@RequestMapping("/api") // RestController understand that return type will be json then it
public class TopicRestController { // automatically return object in json format.

	@Autowired
	private TopicServiceWithoutDB topicservice;

	@RequestMapping(value = "/topics") // No need to @ResponseBody or something.
	public ResponseEntity<Iterable<Topic>> getAllTopics() {

		return new ResponseEntity<>(topicservice.getAllTopics(), HttpStatus.OK);

	}

	@Timed(value = "API.Topic.Endpoint", extraTags = { "method", "getTopic" }, percentiles = { .25, .5, .75, .99 }, histogram = true)
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable int id) throws ElementNotFound {
		Topic out = null;
		try {
			out = topicservice.getTopic(id);
		} catch (NoSuchElementException e) {
			throw new ElementNotFound();
		}

		return out;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public ResponseEntity addTopic(@RequestBody Topic topic) {
		topicservice.addTopic(topic);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable int id) {
		topicservice.updateTopic(topic, id);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public ResponseEntity deleteTopic(@PathVariable int id) {

		try {
			topicservice.deleteTopic(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
