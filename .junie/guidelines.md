# All Citizens Guidelines

## Coding Conventions
- Java 21 with Maven multi-module build; hexagonal (ports and adapters) style kept throughout.
- Packages follow `br.com.all.citizens.<context>` lowercase paths; classes use UpperCamelCase; commands/DTOs often defined as Java `record` types.
- Domain models favor immutable state (final fields) with static factories `newX` and `with`; timestamps use `Instant`; domain exceptions extend `RuntimeException` with clear messages.
- Application layer defines `<Action><Aggregate>UseCase` interfaces with a single `execute` method, implemented by Spring `@Service` classes using constructor injection and `@Transactional` where persistence is involved.
- Controllers return `ResponseEntity`, map nouns as paths (e.g., `/department`), and rely on dedicated mapper classes to convert between domain objects and request/response DTOs.
- Persistence adapters convert domain objects to `Jpa...Entity` classes via mapper helpers; Spring Data repository interfaces sit under `adapter/outbound/persistence/repository` and are wrapped by domain-facing repository implementations.
- Tests and local variables frequently use `var`; test names follow the `given...when...then...` convention; Mockito is used for collaborators and argument capture.

## Code Organization and Package Structure
- Root modules: `domain`, `application`, and `infrastructure` declared in the parent POM.
- `domain`: aggregates such as `department`, `topic`, `subtopic`, `citizen`, `employee`, `person`, `userAccount`, plus `exception`; contains plain Java models and repository interfaces.
- `application`: per-aggregate folders with `command/` (records), `usecase/` (interfaces), `service/` (use case implementations), and shared `utils/`; orchestrates domain logic by calling repository ports.
- `infrastructure`: Spring Boot layer with Undertow web server configuration, global exception handling under `configuration/handler`, inbound REST controllers/DTOs/mappers under `adapter/inbound/rest`, outbound persistence adapters under `adapter/outbound/persistence` with JPA entities and Spring Data repositories, and Flyway SQL migrations in `src/main/resources/db/migration` alongside profile-specific `application-*.yml` configs.

## Unit and Integration Testing Approaches
- Domain tests (`domain/src/test/...`) use JUnit 5 to validate entity factory methods and invariants (e.g., `DepartmentTest`, `CitizenTest`).
- Application tests (`application/src/test/...`) combine JUnit 5 with Mockito (`@ExtendWith(MockitoExtension.class)`) to isolate services, verify repository interactions, and assert exception handling, following the given/when/then naming style.
- Infrastructure tests currently consist of `MainTest`, which boots the application with the `test` profile; the infrastructure POM includes H2 and Flyway test dependencies, indicating support for database-backed integration tests even though controller/persistence integration suites are not yet present.

## Improvement Tasks
- Add validation on REST DTOs with Bean Validation annotations and enrich `GlobalExceptionHandler` to return structured 400 responses.
- Create integration tests for controllers and persistence using Spring Boot, H2, and Flyway covering Department/Topic/SubTopic/Citizen flows.
- Expand application-layer tests to cover find-all, subtree edge cases, and update/delete with nonexistent IDs; prefer AssertJ for fluent assertions.
- Harden domain factories and services with null/optional checks, especially around parentDepartment relationships.
- Introduce consistent SLF4J logging in services/controllers and propagate request/response tracing identifiers.
- Configure CI (e.g., GitHub Actions) to run `mvn test`, static analysis (SpotBugs/Checkstyle), and publish coverage.
- Generate and publish OpenAPI docs via springdoc, adding examples/descriptions to DTOs.
- Add Flyway repeatable scripts and tests that validate schema against JPA mappings.
- Implement repository contract tests to ensure mapping parity between domain models and JPA entities.
- Extend README with local setup, profiles, database, migrations, and quick-start commands (Makefile or scripts).
