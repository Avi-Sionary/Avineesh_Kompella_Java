package com.company.Summative2KompellaAvineesh.Controller;

import com.company.Summative2KompellaAvineesh.Model.Author;
import com.company.Summative2KompellaAvineesh.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository repo;

    // Create
    @PostMapping(value = "/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author) {
        return repo.save(author);
    }

    // Read
    @GetMapping(value = "/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable int id) {
        Optional<Author> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    // Read all
    @GetMapping(value = "/author")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAuthors() {
        return repo.findAll();
    }

    // Update
    @PutMapping(value = "/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAuthor(@RequestBody Author author, @PathVariable int id) {
        Author author1 = repo.findById(id)
                .map(a -> {
                    a.setFirst_name(author.getFirst_name());
                    a.setLast_name(author.getLast_name());
                    a.setStreet(author.getStreet());
                    a.setCity(author.getCity());
                    a.setState(author.getState());
                    a.setPostal_code(author.getPostal_code());
                    a.setPhone(author.getPhone());
                    a.setEmail(author.getEmail());
                    return repo.save(author);
                }).orElseGet(() -> {
                    author.setAuthor_id(id);
                    return repo.save(author);
        });

        repo.save(author);
    }

    // Delete
    @DeleteMapping(value = "/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) {
        repo.deleteById(id);
    }

}
