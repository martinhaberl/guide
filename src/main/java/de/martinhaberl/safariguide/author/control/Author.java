package de.martinhaberl.safariguide.author.control;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;


@Data
public class Author {

    private UUID id;
    private Instant createdAt;
    private Instant modifiedAt;
    private int version;
    private String name;
    private String emailAddress;


    public Author() {
    }

    public Author(UUID id, Instant createdAt, Instant modifiedAt, int version, String name, String emailAddress) {
        this.id = id;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.version = version;
        this.name = name;
        this.emailAddress = emailAddress;
    }

}
