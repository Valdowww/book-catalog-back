package com.catalog.book.controller;

import com.catalog.book.entity.Book;
import com.catalog.book.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Books", description = "Gestion du catalogue de livres")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Lister les livres avec pagination et recherche")
    public Page<Book> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "title") String sort,
            @RequestParam(required = false) String search) {
        return service.findAll(page, size, sort, search);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un livre par son ID")
    public Book getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau livre")
    public ResponseEntity<Book> create(@Valid @RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(book));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un livre")
    public Book update(@PathVariable Long id, @Valid @RequestBody Book book) {
        return service.update(id, book);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un livre")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
