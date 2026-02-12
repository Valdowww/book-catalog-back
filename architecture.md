Projet : Catalogue de Livres (Full-Stack)

1. Architecture Globale L'application sépare le Front-end du Back-end. Ils communiquent par une API REST via le format JSON.

2. Le Back-end (Spring Boot) Il gère les données et les règles métier.
Entity : Objet Java lié à la table SQL.
Repository : Interface pour les requêtes automatiques (JPA).
Controller : Expose les routes (ex: /api/books).

3. Le Front-end (Angular) Il gère l'interface utilisateur dans le navigateur.
Services : Utilisent HttpClient pour appeler l'API.
Composants : Gèrent l'affichage et les clics (Liste, Formulaire)