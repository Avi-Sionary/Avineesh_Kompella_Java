package com.company.Summative2KompellaAvineesh.Repository;

import com.company.Summative2KompellaAvineesh.Model.Author;
import com.company.Summative2KompellaAvineesh.Model.Book;
import com.company.Summative2KompellaAvineesh.Model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception {
        bookRepository.deleteAll();
    }

    // add/create, read, delete
    @Test
    public void addGetDeleteBook() {

        Author author = new Author();
        author.setFirst_name("Bram");
        author.setLast_name("Stoker");
        author.setStreet("Clontarf");
        author.setCity("Dublin");
        author.setState("California"); // Because Ireland isn't a state
        author.setPostal_code("12345");
        author.setPhone("123-456-7890");
        author.setEmail("StokerIsDead@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("Archibald Constable and Company");
        publisher.setCity("London");
        publisher.setCity("Michigan"); // Because the UK isn't a state
        publisher.setPostal_code("66666");
        publisher.setPhone("908-765-4321");
        publisher.setEmail("publishing@ArchibaldConstable.com");

        Book book = new Book();
        book.setIsbn("978-3-16-148410-0"); // I googled this lol
        LocalDate date = LocalDate.of(1897, 5, 26);
        book.setPublish_date(date);
        book.setAuthor_id(author.getAuthor_id());
        book.setPublisher_id(publisher.getPublisher_id());
        book.setTitle("Dracula");
        book.setPrice(BigDecimal.valueOf(32.49));

        // Add
        book = bookRepository.save(book);

        // Get
        Optional<Book> bookCopy = bookRepository.findById(book.getBook_id());
        assertEquals(bookCopy.get(), book);

        // Delete
        bookRepository.deleteById(book.getBook_id());
        bookCopy = bookRepository.findById(book.getBook_id());
        assertFalse(bookCopy.isPresent());

    }

    // read all
    @Test
    public void getAllBooks() {

        Author author1 = new Author();
        author1.setFirst_name("Bram");
        author1.setLast_name("Stoker");
        author1.setStreet("Clontarf");
        author1.setCity("Dublin");
        author1.setState("California"); // Because Ireland isn't a state
        author1.setPostal_code("12345");
        author1.setPhone("123-456-7890");
        author1.setEmail("StokerIsDead@gmail.com");

        Publisher publisher1 = new Publisher();
        publisher1.setName("Archibald Constable and Company");
        publisher1.setCity("London");
        publisher1.setCity("Michigan"); // Because the UK isn't a state
        publisher1.setPostal_code("66666");
        publisher1.setPhone("908-765-4321");
        publisher1.setEmail("publishing@ArchibaldConstable.com");

        Book book1 = new Book();
        book1.setIsbn("978-3-16-148410-0"); // I googled this lol
        LocalDate date = LocalDate.of(1897, 5, 26);
        book1.setPublish_date(date);
        book1.setAuthor_id(author1.getAuthor_id());
        book1.setPublisher_id(publisher1.getPublisher_id());
        book1.setTitle("Dracula");
        book1.setPrice(BigDecimal.valueOf(32.49));

        book1 = bookRepository.save(book1);

        Author author2 = new Author();
        author2.setFirst_name("Fake");
        author2.setLast_name("Name");
        author2.setStreet("A Street");
        author2.setCity("Portland");
        author2.setState("Oregon");
        author2.setPostal_code("99999");
        author2.setPhone("999-999-9999");
        author2.setEmail("myEmail@yahoo.com");

        Publisher publisher2 = new Publisher();
        publisher2.setName("A Publisher");
        publisher2.setCity("New York City");
        publisher2.setCity("New York");
        publisher2.setPostal_code("11111");
        publisher2.setPhone("111-111-1111");
        publisher2.setEmail("publishing@APublisher.com");

        Book book2 = new Book();
        book2.setIsbn("918-2-13-141410-0");
        LocalDate date2 = LocalDate.of(2018, 8, 13);
        book2.setPublish_date(date);
        book2.setAuthor_id(author2.getAuthor_id());
        book2.setPublisher_id(publisher2.getPublisher_id());
        book2.setTitle("A Big Stupid Book");
        book2.setPrice(BigDecimal.valueOf(32.49));

        book2 = bookRepository.save(book2);

        Book book3 = new Book();
        book3.setIsbn("988-1-11-111410-0");
        LocalDate date3 = LocalDate.of(2020, 9, 1);
        book3.setPublish_date(date);
        book3.setAuthor_id(author2.getAuthor_id());
        book3.setPublisher_id(publisher2.getPublisher_id());
        book3.setTitle("Another Big Stupid Book");
        book3.setPrice(BigDecimal.valueOf(32.49));

        book3 = bookRepository.save(book3);

        List<Book> allBooks = bookRepository.findAll();
        assertEquals(allBooks.size(), 3);

    }

    // get book by author
    @Test
    public void getBookByAuthor() {

        Author author = new Author();
        author.setFirst_name("Bram");
        author.setLast_name("Stoker");
        author.setStreet("Clontarf");
        author.setCity("Dublin");
        author.setState("California"); // Because Ireland isn't a state
        author.setPostal_code("12345");
        author.setPhone("123-456-7890");
        author.setEmail("StokerIsDead@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("Archibald Constable and Company");
        publisher.setCity("London");
        publisher.setCity("Michigan"); // Because the UK isn't a state
        publisher.setPostal_code("66666");
        publisher.setPhone("908-765-4321");
        publisher.setEmail("publishing@ArchibaldConstable.com");

        Book book = new Book();
        book.setIsbn("978-3-16-148410-0"); // I googled this lol
        LocalDate date = LocalDate.of(1897, 5, 26);
        book.setPublish_date(date);
        book.setAuthor_id(author.getAuthor_id());
        book.setPublisher_id(publisher.getPublisher_id());
        book.setTitle("Dracula");
        book.setPrice(BigDecimal.valueOf(32.49));

        // Add
        book = bookRepository.save(book);

        // Get by author
        Optional<Book> Dracula = bookRepository.findByAuthor("Bram Stoker");
        assertEquals(Dracula.get().getAuthor_id(), book.getAuthor_id());

    }

    // update
    @Test
    public void updateBook() {

        Author author = new Author();
        author.setFirst_name("Bram");
        author.setLast_name("Stoker");
        author.setStreet("Clontarf");
        author.setCity("Dublin");
        author.setState("California"); // Because Ireland isn't a state
        author.setPostal_code("12345");
        author.setPhone("123-456-7890");
        author.setEmail("StokerIsDead@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("Archibald Constable and Company");
        publisher.setCity("London");
        publisher.setState("Michigan"); // Because the UK isn't a state
        publisher.setPostal_code("66666");
        publisher.setPhone("908-765-4321");
        publisher.setEmail("publishing@ArchibaldConstable.com");

        Book book = new Book();
        book.setIsbn("978-3-16-148410-0"); // I googled this lol
        LocalDate date = LocalDate.of(1897, 5, 26);
        book.setPublish_date(date);
        book.setAuthor_id(author.getAuthor_id());
        book.setPublisher_id(publisher.getPublisher_id());
        book.setTitle("Dracula");
        book.setPrice(BigDecimal.valueOf(32.49));

        // Add
        book = bookRepository.save(book);

        // UPDATE
        book.setTitle("Akumajou Dracula");
        LocalDate newDate = LocalDate.of(1993, 7, 27);
        book.setPublish_date(newDate);
        book = bookRepository.save(book);

        Optional<Book> theBook = bookRepository.findById(book.getBook_id());
        assertEquals(theBook.get(), book);

    }

}
