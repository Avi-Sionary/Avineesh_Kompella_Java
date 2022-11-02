package com.company.Summative2KompellaAvineesh.Controller;

import com.company.Summative2KompellaAvineesh.Model.Book;
import com.company.Summative2KompellaAvineesh.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository repo;

    // Create
    @PostMapping(value = "/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return repo.save(book);
    }

    // Read
    @GetMapping(value = "/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable int id) {
        Optional<Book> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    // Read all
    @GetMapping(value = "/book")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooks() {
        return repo.findAll();
    }

    // Search by author
    @GetMapping(value = "/book/author/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findByAuthor(@PathVariable int authorId) {
        return repo.findAllBooksByAuthorId(authorId);
    }

    // Update
    @PutMapping(value = "/book/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book updateBookById(@RequestBody Book book, @PathVariable int id) {
        Book newBook = repo.findById(id)
                .map(b -> {
                    b.setIsbn(book.getIsbn());
                    b.setPublish_date(book.getPublish_date());
                    b.setAuthorId(book.getAuthorId());
                    b.setTitle(book.getTitle());
                    b.setPublisherId(book.getPublisherId());
                    b.setPrice(book.getPrice());
                    return repo.save(book);
                }) .orElseGet(() -> {
                    book.setBookId(id);
                    return repo.save(book);
                });

        return repo.save(book);
    }

    // Delete
    @DeleteMapping("/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        repo.deleteById(id);
    }

}
