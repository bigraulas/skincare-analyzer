# Skincare Ingredient Analyzer

Raul invata programare. El scrie tot codul. Eu doar ghidez si fac code review.

NU scrie cod in locul lui. In schimb:
- Explica ce trebuie facut pas cu pas
- Fa review la codul pe care il scrie
- Indica greseli si explica de ce sunt greseli
- Raspunde la intrebari
## Despre proiect
  Aplicatie care analizeaza ingredientele produselor skincare.
  Backend: Java 17 + Spring Boot 4 + PostgreSQL.
  Frontend: React (se adauga in Faza 3).
  API-uri externe: Open Beauty Facts (gratuit) + INCI API (gratuit, 20k req/luna).

## Structura proiect
  skincare-analyzer/
  backend/
  src/main/java/ro/skincare/analyzer/
  model/          - Entitati JPA
  repository/     - JpaRepository interfaces
  service/        - Logica de business
  controller/     - REST endpoints
  client/         - Clase care cheama API-uri externe
  src/main/resources/
  application.properties
  pom.xml
  frontend/           - Se adauga in Faza 3

  ## Faza 1: Backend CRUD
  Entitati:
    - Ingredient: id, numeInci, descriere, scorSiguranta (1-10), eComedogenic (boolean), functie
    - Produs: id, nume, brand, listaIngrediente (text brut). Many-to-many cu Ingredient.
    - Rutina: id, nume, tipPiele (enum: GRASA, USCATA, MIXTA, SENSIBILA)
    - RutinaProdus: legatura Rutina-Produs cu ordine si momentZi (DIMINEATA/SEARA)

  Endpoints:
    - CRUD /api/ingrediente
    - CRUD /api/produse
    - CRUD /api/rutine
    - GET /api/produse/{id}/ingrediente
    - POST /api/rutine/{id}/produse

  Pasi:
    1. Creeaza proiectul Spring Boot
    2. Configureaza PostgreSQL (db: skincare_analyzer_db)
    3. Entitatea Ingredient + repository + service + controller
    4. Entitatea Produs + relatia many-to-many cu Ingredient
    5. Controller/service pentru Produs
    6. Entitatea Rutina cu enum TipPiele
    7. RutinaProdus + relatia Rutina-Produs
    8. Testeaza totul cu curl
    9. Pune pe Git/GitHub

  ## Faza 2: Integrare API extern
    - GET /api/produse/scan/{barcode} - cauta produs pe Open Beauty Facts
    - GET /api/ingrediente/{nume}/siguranta - scor siguranta de la INCI API
    - GET /api/produse/{id}/analiza - analiza completa produs
    - Invata: RestTemplate/WebClient, JSON parsing, error handling API extern

  ## Faza 3: Frontend React
    - Homepage: cauta produs sau scaneaza barcode
    - Pagina produs: ingrediente cu scoruri colorate
    - Rutina mea: produse cu ordine dimineata/seara
    - Analiza rutina: conflicte intre ingrediente

  ## Faza 4: Features avansate
    - Autentificare (user cu rutina proprie)
    - Comparare produse (A vs B)
    - Alerte ingrediente (ex: retinol + AHA nu se combina)
    - Deploy (Docker + cloud)