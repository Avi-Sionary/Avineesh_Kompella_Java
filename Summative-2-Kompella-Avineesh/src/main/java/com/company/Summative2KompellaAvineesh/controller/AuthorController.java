package com.company.Summative2KompellaAvineesh.controller;

import com.company.Summative2KompellaAvineesh.model.Author;
import com.company.Summative2KompellaAvineesh.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository repo;

    // Create
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author) {
        return repo.save(author);
    }

    // Read
    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable int id) {
        Optional<Author> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    // Read all
    @GetMapping("/authors")
    public List<Author> getAuthors() { return repo.findAll();}

    // Update
    @PutMapping("/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@RequestBody Author author) {
        repo.save(author);
    }

    // Delete
    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) {
        repo.deleteById(id);
    }

}
