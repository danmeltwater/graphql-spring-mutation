
## Build
Clone repository and do gradle build `./gradlew clean build`.

Java version : Java 17

## Code explanation

- `resources/graphql/editorialdocument.graphql` contains schema of GraphQL API
- `EditorialDocumentController` provides implementation of all GraphQL example
- `domain.model` contains domain model
- `domain.repository` contains Spring JPA implementation of repository. Repository is implemented using in memory H2 database
- `domain.repository.model` contains database representation domain model
- `domain.repository.mapper` contains classes which maps domain object to database object
- `application.service` package contains service classes
- `resources\data.sql` contains insert statements to bootstrap book and rating data so that Query returns some result without mutation 


By default, the data.sql script executes before Hibernate initialization. 
As we're relying on Hibernate to create table, we need to set `spring.jpa.defer-datasource-initialization=true`
