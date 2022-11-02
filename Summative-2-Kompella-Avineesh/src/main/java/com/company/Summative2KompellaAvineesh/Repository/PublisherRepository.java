package com.company.Summative2KompellaAvineesh.Repository;

import com.company.Summative2KompellaAvineesh.Model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>{
}
