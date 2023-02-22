package de.martinhaberl.safariguide.author.boundary;

import java.util.UUID;

public record AuthorResponseDTO(UUID id, String name, String email) {

}
