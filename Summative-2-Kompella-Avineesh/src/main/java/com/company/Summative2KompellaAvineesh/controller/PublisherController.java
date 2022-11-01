package com.company.Summative2KompellaAvineesh.controller;

import com.company.Summative2KompellaAvineesh.model.Publisher;
import com.company.Summative2KompellaAvineesh.repository.PublisherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class PublisherController {

    @Autowired
    PublisherRepository repo;

    // Create
    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return repo.save(publisher);
    }

    // Read
    @GetMapping("/publishers/{id}")
    public Publisher getPublisherById(@PathVariable int id) {
        Optional<Publisher> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    // Read all
    @GetMapping("/publishers")
    public List<Publisher> getPublishers() { return repo.findAll();}

    // Update
    @PutMapping("/publishers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher publisher) {
        repo.save(publisher);
    }

    // Delete
    @DeleteMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id) {
        repo.deleteById(id);
    }

}
