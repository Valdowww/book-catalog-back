# Book Catalog — Spring Boot + Angular

Application de gestion d'un catalogue de livres (CRUD complet).

## Prérequis

- Java 17+
- Maven 3.8+ (`mvn -v` pour vérifier, sinon : https://maven.apache.org/download.cgi)
- Node.js 18+ / npm 9+
- Angular CLI 17+ (`npm install -g @angular/cli`)

## Lancement

### 1. Back-end

```bash
cd book-catalog-back
mvn clean spring-boot:run
```

Attendre `Started BookCatalogApplication` puis accéder à :
- API : http://localhost:8080
- Swagger : http://localhost:8080/swagger-ui.html 

### 2. Front-end (dans un autre terminal)

```bash
cd book-catalog-front
npm install
ng serve
```

Application disponible sur **http://localhost:4200**

> Les deux terminaux doivent rester ouverts en même temps.

---

## Fonctionnalités de base (CRUD)
- Lister les livres
- Ajouter un livre (formulaire validé)
- Modifier un livre
- Supprimer un livre (avec confirmation)

## Bonus réalisés
- **Pagination et tri** côté back (Spring Data) et front (Angular Material)
- **Recherche** temps réel sur titre, auteur et catégorie (avec debounce)
- **Validation** des formulaires (Angular Reactive Forms + Bean Validation Java)
- **Angular Material** pour l'interface (tableau, formulaires, snackbars, dialog)
- **Swagger / OpenAPI** pour la documentation de l'API (http://localhost:8080/swagger-ui.html)
- **Gestion des erreurs** HTTP (400, 404, 500) côté back et front

---