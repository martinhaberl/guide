package de.martinhaberl.safariguide.article.boundary;

import java.util.UUID;

public record ArticleRequestDTO(String Headline, String text, UUID authorId) {
}
