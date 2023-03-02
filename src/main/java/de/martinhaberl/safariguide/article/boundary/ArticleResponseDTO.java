package de.martinhaberl.safariguide.article.boundary;

import java.util.UUID;

public record ArticleResponseDTO(String headline, String text, UUID author) {
}
