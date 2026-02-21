package com.catalog.book.service;

import com.catalog.book.entity.Book;
import com.catalog.book.repository.BookRepository;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Page<Book> findAll(int page, int size, String sort, String search) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort).ascending());
        if (search != null && !search.isBlank()) {
            return repository.searchBooks(search.trim(), pageable);
        }
        return repository.findAll(pageable);
    }

    public Book findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livre introuvable"));
    }

    public Book create(Book book) {
        return repository.save(book);
    }

    public Book update(Long id, Book book) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livre introuvable");
        }
        book.setId(id);
        return repository.save(book);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livre introuvable");
        }
        repository.deleteById(id);
    }
}
