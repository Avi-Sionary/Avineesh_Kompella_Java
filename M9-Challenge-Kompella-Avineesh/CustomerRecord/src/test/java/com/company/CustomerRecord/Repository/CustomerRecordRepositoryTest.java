package com.company.CustomerRecord.Repository;

import com.company.CustomerRecord.Model.CustomerRecord;
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
public class CustomerRecordRepositoryTest {

    @Autowired
    CustomerRecordRepository customerRecordRepository;

    @Before
    public void setUp() throws Exception {
        customerRecordRepository.deleteAll();
    }

    @Test
    public void addGetDeleteRecord() {

        CustomerRecord customerRecord = new CustomerRecord();
        customerRecord.setFirstName("Grand");
        customerRecord.setLastName("Dad");
        customerRecord.setEmail("grandDad7@siivagunner.com");
        customerRecord.setCompany("Siivagunner");
        customerRecord.setPhone("111-222-3333");
        customerRecord.setAddress_1("4567 A Fake Street");
        customerRecord.setAddress_2("Apt 890");
        customerRecord.setCity("Los Angeles");
        customerRecord.setState("California");
        customerRecord.setPostalCode(12345);
        customerRecord.setCountry("United States");
        customerRecord = customerRecordRepository.save(customerRecord);

        Optional<CustomerRecord> customerRecord1 = customerRecordRepository.findById(customerRecord.getId());

        assertEquals(customerRecord1.get(), customerRecord);

        customerRecordRepository.deleteById(customerRecord.getId());

        customerRecord1 = customerRecordRepository.findById(customerRecord.getId());

        assertFalse(customerRecord1.isPresent());
    }

    @Test
    public void updateRecord() {

        CustomerRecord customerRecord = new CustomerRecord();
        customerRecord.setFirstName("Grand");
        customerRecord.setLastName("Dad");
        customerRecord.setEmail("grandDad7@siivagunner.com");
        customerRecord.setCompany("Siivagunner");
        customerRecord.setPhone("111-222-3333");
        customerRecord.setAddress_1("4567 A Fake Street");
        customerRecord.setAddress_2("Apt 890");
        customerRecord.setCity("Los Angeles");
        customerRecord.setState("California");
        customerRecord.setPostalCode(12345);
        customerRecord.setCountry("United States");

        customerRecord = customerRecordRepository.save(customerRecord);

        customerRecord.setCompany("Nike");
        customerRecord.setPostalCode(67890);

        customerRecord = customerRecordRepository.save(customerRecord);

        Optional<CustomerRecord> customerRecord2 = customerRecordRepository.findById(customerRecord.getId());
        assertEquals(customerRecord2.get(), customerRecord);
    }

    @Test
    public void getRecordByState() {

        CustomerRecord customerRecord = new CustomerRecord();
        customerRecord.setFirstName("Grand");
        customerRecord.setLastName("Dad");
        customerRecord.setEmail("grandDad7@siivagunner.com");
        customerRecord.setCompany("Siivagunner");
        customerRecord.setPhone("111-222-3333");
        customerRecord.setAddress_1("4567 A Fake Street");
        customerRecord.setAddress_2("Apt 890");
        customerRecord.setCity("Los Angeles");
        customerRecord.setState("California");
        customerRecord.setPostalCode(12345);
        customerRecord.setCountry("United States");

        customerRecord = customerRecordRepository.save(customerRecord);

        CustomerRecord customerRecord1 = new CustomerRecord();
        customerRecord1.setFirstName("Clark");
        customerRecord1.setLastName("Kent");
        customerRecord1.setEmail("notClarkKent@notAnEmail.com");
        customerRecord1.setCompany("Daily Planet");
        customerRecord1.setPhone("444-222-3333");
        customerRecord1.setAddress_1("4567 A Very Fake Street");
        customerRecord1.setAddress_2("Apt 420");
        customerRecord1.setCity("A City");
        customerRecord1.setState("Arkansas");
        customerRecord1.setPostalCode(10101);
        customerRecord1.setCountry("United States");

        customerRecord1 = customerRecordRepository.save(customerRecord1);

        Optional<CustomerRecord> customerRecords = customerRecordRepository.findByState("Arkansas");

        assertEquals(customerRecords.get(), customerRecord1);
    }
}
