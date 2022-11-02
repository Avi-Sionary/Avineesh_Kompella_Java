package com.company.Summative2KompellaAvineesh.Repository;

import com.company.Summative2KompellaAvineesh.Model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception {
        publisherRepository.deleteAll();
    }

    // add/create, read, delete
    @Test
    public void addGetDeletePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("Archibald Constable and Company");
        publisher.setCity("London");
        publisher.setState("Michigan"); // Because the UK isn't a state
        publisher.setPostalCode("66666");
        publisher.setPhone("908-765-4321");
        publisher.setEmail("publishing@ArchibaldConstable.com");

        // Add
        publisher = publisherRepository.save(publisher);

        // Get
        Optional<Publisher> publisherCopy = publisherRepository.findById(publisher.getPublisher_id());
        assertEquals(publisherCopy.get(), publisher);

        // Delete
        publisherRepository.deleteById(publisher.getPublisher_id());
        publisherCopy = publisherRepository.findById(publisher.getPublisher_id());
        assertFalse(publisherCopy.isPresent());

    }

    // read all
    @Test
    public void getAllPublishers() {

        Publisher publisher1 = new Publisher();
        publisher1.setName("Archibald Constable and Company");
        publisher1.setCity("London");
        publisher1.setCity("Michigan"); // Because the UK isn't a state
        publisher1.setPostalCode("66666");
        publisher1.setPhone("908-765-4321");
        publisher1.setEmail("publishing@ArchibaldConstable.com");

        publisher1 = publisherRepository.save(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("A Publisher");
        publisher2.setCity("New York City");
        publisher2.setCity("New York");
        publisher2.setPostalCode("11111");
        publisher2.setPhone("111-111-1111");
        publisher2.setEmail("publishing@APublisher.com");

        publisher2 = publisherRepository.save(publisher2);

        List<Publisher> allPublishers = publisherRepository.findAll();
        assertEquals(allPublishers.size(), 2);

    }

    // update
    @Test
    public void updatePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("Archibald Constable and Company");
        publisher.setCity("London");
        publisher.setState("Michigan"); // Because the UK isn't a state
        publisher.setPostalCode("66666");
        publisher.setPhone("908-765-4321");
        publisher.setEmail("publishing@ArchibaldConstable.com");

        // Add
        publisher = publisherRepository.save(publisher);

        // UPDATE
        publisher.setName("Konami");
        publisher.setCity("Detroit");
        publisher = publisherRepository.save(publisher);

        Optional<Publisher> thePublisher = publisherRepository.findById(publisher.getPublisher_id());
        assertEquals(thePublisher.get(), publisher);

    }
}
