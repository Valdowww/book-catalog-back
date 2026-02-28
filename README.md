# Book Catalog — API Spring Boot + Front Angular

Application full-stack de gestion d'un catalogue de livres (CRUD complet avec recherche et pagination).

---

## Prérequis

| Outil | Version minimale |
|-------|-----------------|
| Java | 17 |
| Maven | 3.8+ |
| Node.js | 18+ |
| npm | 9+ |
| Angular CLI | 17+ |

---

## Lancement du back-end

```bash
cd book-catalog-back
mvn spring-boot:run
```

L'API démarre sur **http://localhost:8080**

- Swagger UI : http://localhost:8080/swagger-ui.html
- Console H2 : http://localhost:8080/h2-console (JDBC URL : `jdbc:h2:mem:bookdb`, user : `sa`, pas de mot de passe)

---

## Lancement du front-end

```bash
cd book-catalog-front
npm install
ng serve
```

L'application démarre sur **http://localhost:4200**

---

## Endpoints API

| Méthode | URL | Description | Code retour |
|---------|-----|-------------|-------------|
| GET | `/api/books` | Lister (pagination + recherche) | 200 |
| GET | `/api/books/{id}` | Récupérer un livre | 200 / 404 |
| POST | `/api/books` | Créer un livre | 201 / 400 |
| PUT | `/api/books/{id}` | Mettre à jour | 200 / 400 / 404 |
| DELETE | `/api/books/{id}` | Supprimer | 204 / 404 |

### Paramètres de l'endpoint GET /api/books

| Paramètre | Type | Défaut | Description |
|-----------|------|--------|-------------|
| `page` | int | 0 | Numéro de page |
| `size` | int | 10 | Taille de page |
| `sort` | string | title | Champ de tri |
| `search` | string | - | Recherche sur titre, auteur, catégorie |

---

## Structure des projets

```
book-catalog-back/
├── src/main/java/com/catalog/book/
│   ├── BookCatalogApplication.java
│   ├── OpenApiConfig.java
│   ├── entity/Book.java
│   ├── repository/BookRepository.java
│   ├── service/BookService.java
│   └── controller/
│       ├── BookController.java
│       └── GlobalExceptionHandler.java
└── src/main/resources/
    ├── application.properties
    └── data.sql

book-catalog-front/
└── src/app/
    ├── models/book.model.ts
    ├── services/book.service.ts
    ├── app.routes.ts
    ├── app.config.ts
    └── components/
        ├── book-list/
        ├── book-form/
        └── confirm-dialog/
```
