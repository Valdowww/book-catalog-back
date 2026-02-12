package com.example.bookcatalog.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books") // Optionnel : définit explicitement le nom de la table
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String author;

    // On renomme la colonne en base pour éviter le mot réservé SQL "YEAR"
    @Column(name = "publishing_year")
    private Integer year;
    
    private String category;

    // Constructeur par défaut requis par JPA
    public Book() {}

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}