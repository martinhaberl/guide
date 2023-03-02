package de.martinhaberl.safariguide.article.control;

import java.util.UUID;

public interface IArticleService {
    Article createArticle(String headline, String text, UUID authorId);
}
