package de.martinhaberl.safariguide.author.boundary;

import java.util.UUID;

public record AuthorResponseDTO(UUID id, String name, String emailAddress) {

    public AuthorResponseDTO(UUID id, String name, String emailAddress) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
    }
}
