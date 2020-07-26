package in.co.bytehub.topic.service;

import in.co.bytehub.restapi.app.model.Topic;
import in.co.bytehub.restapi.app.repo.TopicRepositoryJPA;
import in.co.bytehub.restapi.app.service.TopicServiceWithDB;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class TopicServiceWithDBTEst {

    TopicRepositoryJPA repo = Mockito.mock(TopicRepositoryJPA.class);
    TopicServiceWithDB serviceWithDB = new TopicServiceWithDB(repo);

    @Test
    public void testGetTopic(){
        Topic mockedResult = new Topic();
        mockedResult.setName("DS");

        Mockito
                .when(repo.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(mockedResult));


        Topic topic = serviceWithDB.getTopic(15);

        assert topic.getName().equals(mockedResult.getName());
    }

}
