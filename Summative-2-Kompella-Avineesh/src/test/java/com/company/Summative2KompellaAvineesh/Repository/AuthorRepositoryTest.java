package com.company.Summative2KompellaAvineesh.Repository;

import com.company.Summative2KompellaAvineesh.Model.Author;
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
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Before
    public void setUp() throws Exception {
        authorRepository.deleteAll();
    }

    // add/create read delete
    @Test
    public void addGetDeleteAuthor() {

        Author author = new Author();
        author.setFirst_name("Bram");
        author.setLast_name("Stoker");
        author.setStreet("Clontarf");
        author.setCity("Dublin");
        author.setState("CA"); // Because Ireland isn't a state
        author.setPostal_code("12345");
        author.setPhone("123-456-7890");
        author.setEmail("StokerIsDead@gmail.com");
        // Add
        author = authorRepository.save(author);

        // Get
        Optional<Author> authorCopy = authorRepository.findById(author.getAuthorId());
        assertEquals(authorCopy.get(), author);

        // Delete
        authorRepository.deleteById(author.getAuthorId());
        authorCopy = authorRepository.findById(author.getAuthorId());
        assertFalse(authorCopy.isPresent());

    }

    // read all
    @Test
    public void getAllAuthors() {

        Author author1 = new Author();
        author1.setFirst_name("Bram");
        author1.setLast_name("Stoker");
        author1.setStreet("Clontarf");
        author1.setCity("Dublin");
        author1.setState("CA"); // Because Ireland isn't a state
        author1.setPostal_code("12345");
        author1.setPhone("123-456-7890");
        author1.setEmail("StokerIsDead@gmail.com");

        author1 = authorRepository.save(author1);

        Author author2 = new Author();
        author2.setFirst_name("Fake");
        author2.setLast_name("Name");
        author2.setStreet("A Street");
        author2.setCity("Portland");
        author2.setState("OR");
        author2.setPostal_code("99999");
        author2.setPhone("999-999-9999");
        author2.setEmail("myEmail@yahoo.com");

        author2 = authorRepository.save(author2);

        List<Author> allAuthors = authorRepository.findAll();
        assertEquals(allAuthors.size(), 2);

    }

    // update
    @Test
    public void updateAuthor() {

        Author author = new Author();
        author.setFirst_name("Bram");
        author.setLast_name("Stoker");
        author.setStreet("Clontarf");
        author.setCity("Dublin");
        author.setState("CA"); // Because Ireland isn't a state
        author.setPostal_code("12345");
        author.setPhone("123-456-7890");
        author.setEmail("StokerIsDead@gmail.com");

        // Add
        author = authorRepository.save(author);

        // UPDATE
        author.setFirst_name("Billy");
        author.setStreet("Brooklyn");
        author = authorRepository.save(author);

        Optional<Author> theAuthor = authorRepository.findById(author.getAuthorId());
        assertEquals(theAuthor.get(), author);

    }

}
