package com.company.Summative2KompellaAvineesh.Controller;

import com.company.Summative2KompellaAvineesh.Model.Publisher;
import com.company.Summative2KompellaAvineesh.Repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {

    @Autowired
    PublisherRepository repo;

    // Create
    @PostMapping("/publisher")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return repo.save(publisher);
    }

    // Read
    @GetMapping("/publisher/{id}")
    public Publisher getPublisherById(@PathVariable int id) {
        Optional<Publisher> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    // Read all
    @GetMapping("/publisher")
    public List<Publisher> getPublishers() {
        return repo.findAll();
    }

    // Update
    @PutMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Publisher updatePublisher(@RequestBody Publisher publisher, @PathVariable int id) {
        Publisher newPublisher = repo.findById(id)
                .map(p -> {
                    p.setName(publisher.getName());
                    p.setCity(publisher.getCity());
                    p.setState(publisher.getState());
                    p.setPostalCode(publisher.getPostalCode());
                    p.setPhone(publisher.getPhone());
                    p.setEmail(publisher.getEmail());
                    return repo.save(publisher);
                }).orElseGet(() -> {
                    publisher.setPublisher_id(id);
                    return repo.save(publisher);
                });

        return repo.save(publisher);
    }

    // Delete
    @DeleteMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id) {
        repo.deleteById(id);
    }

}
