package br.com.all.citizens.domain.citizen;

import br.com.all.citizens.domain.person.Person;
import java.time.Instant;

public class Citizen {

    private final Integer personId;   // PK compartilhada com Person
    private final Person person;      // Agregado obrigatório
    private final String socialId;
    private final CitizenType type;
    private final Instant createdAt;

    private Citizen(
            Integer personId,
            Person person,
            String socialId,
            CitizenType type,
            Instant createdAt
    ) {
        this.personId = personId;
        this.person = person;
        this.socialId = socialId;
        this.type = type;
        this.createdAt = createdAt;
    }

    /**
     * Criação de um novo Citizen (lado de domínio).
     * Aqui o person ainda não tem ID (pois será persistido).
     */
    public static Citizen newCitizen(Person person, String socialId, CitizenType type) {
        Instant now = Instant.now();

        return new Citizen(
                null,      // personId só existe após persistência
                person,
                socialId,
                type,
                now
        );
    }

    /**
     * Reconstrução de um Citizen vindo do banco (JPA -> domínio).
     */
    public static Citizen with(
            Integer personId,
            Person person,
            String socialId,
            CitizenType type,
            Instant createdAt
    ) {
        return new Citizen(
                personId,
                person,
                socialId,
                type,
                createdAt
        );
    }

    public Integer getPersonId() { return personId; }

    public Person getPerson() { return person; }

    public String getSocialId() { return socialId; }

    public CitizenType getType() { return type; }

    public Instant getCreatedAt() { return createdAt; }
}
