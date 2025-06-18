To jest prosta aplikacja webowa typu REST API stworzona w Javie z użyciem Spring Boot. Umożliwia ona:

Rejestrację użytkownika (/register)
Logowanie użytkownika (/login)
Pobieranie listy przedmiotów (/items)
Dodawanie nowego przedmiotu (/items)

Dostęp do endpointów związanych z przedmiotami (/items) mają wyłącznie zalogowani użytkownicy — uwierzytelnienie odbywa
się za pomocą tokena JWT.

**TECHNOLOGIE**

* Java 21
* Spring Boot
* Spring Security
* Hibernate (JPA)
* MySQL
* JWT (JSON Web Token)
* Maven
* Docker + Docker Compose

✅ Wymagania

* Zainstalowany Docker Desktop
* Zainstalowana Java 21
* Zainstalowany Maven
* IDE (np. IntelliJ IDEA)
  ** Krok po kroku **

**Uruchomienie aplickacji**

1. Przejdź do consoli terminal/bash przejdź katalogu tools/database i uruchom:

   ``` ./docker-compose up -d ```

2. Połącz się z bazą np przy użyciu inteliJ

```
   adres : jdbc:mysql://localhost:3306/app_db
   username: mysql
   password: mysql
  ```

3. Uruchom dwa skrypty createUser.sql i createItem.sql
4. Uruchom klase DemoApplications.class
5. W katalogu src/test/java/com/example/demo/httpRequests znajdują się request do testowania API

