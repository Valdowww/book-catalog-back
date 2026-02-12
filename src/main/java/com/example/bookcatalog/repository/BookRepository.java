package com.example.bookcatalog.repository;

import com.example.bookcatalog.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}