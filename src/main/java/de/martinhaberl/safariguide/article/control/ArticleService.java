package de.martinhaberl.safariguide.article.control;

import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class ArticleService implements IArticleService {
    @Override
    public Article createArticle(String headline, String text, UUID authorId) {
        return null;
    }
}
