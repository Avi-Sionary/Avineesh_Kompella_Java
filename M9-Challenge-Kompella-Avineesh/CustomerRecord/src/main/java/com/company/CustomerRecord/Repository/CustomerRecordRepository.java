package com.company.CustomerRecord.Repository;

import com.company.CustomerRecord.Model.CustomerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRecordRepository extends JpaRepository<CustomerRecord, Integer>{

    @Override
    Optional<CustomerRecord> findById(Integer integer);

    Optional<CustomerRecord> findByState(String state);
}
