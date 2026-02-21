# Document de synthèse — Architecture Book Catalog

## Vue d'ensemble

Application web full-stack de type **CRUD monolithique REST** permettant la gestion d'un catalogue de livres. Elle suit une architecture en deux projets distincts qui communiquent exclusivement via HTTP/JSON.

```
Angular (SPA, port 4200)
        ↓  HTTP / JSON
Spring Boot (REST API, port 8080)
        ↓  JPA / Hibernate
Base H2 en mémoire
```

---

## Back-end — Spring Boot

**Stack** : Java 17, Spring Boot 3.2, Spring Data JPA, Hibernate, H2, Springdoc OpenAPI

Architecture en 4 couches :

| Couche | Rôle |
|--------|------|
| `Entity` | Mapping objet-relationnel (Book ↔ table SQL) |
| `Repository` | Accès aux données via Spring Data JPA (CRUD + pagination + recherche JPQL) |
| `Service` | Logique métier, validations, gestion des erreurs métier |
| `Controller` | Exposition REST, codes HTTP, CORS, documentation Swagger |

Un `GlobalExceptionHandler` intercepte les erreurs de validation et les `ResponseStatusException` pour retourner des réponses JSON structurées avec les bons codes HTTP.

---

## Front-end — Angular 17

**Stack** : Angular 17 (standalone components), TypeScript, Angular Material, RxJS

| Élément | Rôle |
|---------|------|
| `BookModel` | Interface TypeScript typant les données de l'API |
| `BookService` | Couche HTTP (HttpClient), seul point d'accès à l'API |
| `BookListComponent` | Affichage, recherche avec debounce, pagination, suppression |
| `BookFormComponent` | Formulaire Reactive Forms avec validation côté client |
| `ConfirmDialogComponent` | Dialog de confirmation avant suppression |

Le routing Angular gère trois routes : `/books`, `/books/new`, `/books/:id/edit`.

---

## Fonctionnalités implémentées

- CRUD complet (Create, Read, Update, Delete)
- Recherche full-text sur titre, auteur et catégorie (debounce 350ms)
- Pagination et tri côté serveur
- Validation des formulaires (Reactive Forms) avec messages d'erreur
- Gestion des erreurs API avec retour utilisateur (snackbar)
- Dialog de confirmation avant suppression
- Documentation API interactive (Swagger UI)
- Codes HTTP sémantiques (200, 201, 204, 400, 404)
