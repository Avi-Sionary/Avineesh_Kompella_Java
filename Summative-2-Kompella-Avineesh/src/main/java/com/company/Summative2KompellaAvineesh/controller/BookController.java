package com.company.Summative2KompellaAvineesh.controller;

import com.company.Summative2KompellaAvineesh.model.Book;
import com.company.Summative2KompellaAvineesh.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository repo;

    // Create
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return repo.save(book);
    }

    // Read
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        Optional<Book> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    // Read all
    @GetMapping("/books")
    public List<Book> getBooks() { return repo.findAll();}

    // Search by author
    @GetMapping("/books/{author}")
    public Optional<Book> getBooksByAuthor(@PathVariable String author) {
        return repo.findByAuthor(author);
    }

    // Update
    @PutMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book book) {
        repo.save(book);
    }

    // Delete
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        repo.deleteById(id);
    }

}
