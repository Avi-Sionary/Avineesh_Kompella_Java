package com.company.CustomerRecord.Controller;

import com.company.CustomerRecord.Model.CustomerRecord;
import com.company.CustomerRecord.Repository.CustomerRecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerRecordController {
    @Autowired
    CustomerRecordRepository repo;

    @GetMapping("/customers")
    public List<CustomerRecord> getCustomerRecords() {
        return repo.findAll();
    }

    @GetMapping("/customers/{id}")
    public CustomerRecord getCustomerRecordById(@PathVariable int id) {

        Optional<CustomerRecord> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerRecord addCustomerRecord(@RequestBody CustomerRecord customerRecord) {
        return repo.save(customerRecord);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlbum(@RequestBody CustomerRecord customerRecord) {
        repo.save(customerRecord);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable int id) {
        repo.deleteById(id);
    }
}
