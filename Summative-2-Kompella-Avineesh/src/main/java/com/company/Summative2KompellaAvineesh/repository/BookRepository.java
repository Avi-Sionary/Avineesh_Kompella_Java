package com.company.Summative2KompellaAvineesh.repository;

import com.company.Summative2KompellaAvineesh.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

    Optional<Book> findByAuthor(String author);

}
