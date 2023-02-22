package de.martinhaberl.safariguide.author;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;


@Getter @Setter
public class Author {

    private final UUID id;
    private Instant createdAt;
    private Instant modifiedAt;
    private int version;
    private String name;
    private String email;

    public Author(String email) {
        this.id = UUID.randomUUID();
    }

    public Author(UUID id, Instant createdAt, Instant modifiedAt, int version, String name, String email) {
        this.id = UUID.randomUUID();
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.version = version;
        this.name = name;
        this.email = email;
    }
}
