package com.catalog.book.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le titre est obligatoire")
    @Size(max = 255)
    private String title;

    @NotBlank(message = "L'auteur est obligatoire")
    @Size(max = 255)
    private String author;

    @NotNull(message = "L'année est obligatoire")
    @Min(value = 0, message = "L'année doit être positive")
    @Max(value = 2100, message = "L'année est invalide")
    private Integer year;

    @NotBlank(message = "La catégorie est obligatoire")
    @Size(max = 100)
    private String category;

    public Book() {}

    public Book(String title, String author, Integer year, String category) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.category = category;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
