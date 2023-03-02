package de.martinhaberl.safariguide.article.boundary;

import de.martinhaberl.safariguide.article.control.Article;
import de.martinhaberl.safariguide.article.control.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    IArticleService iArticleService;

    @Autowired
    public ArticleController(IArticleService injectedIArticleService) {
        this.iArticleService = injectedIArticleService;
    }

    public ArticleResponseDTO createArticle(ArticleRequestDTO articleRequestDTO) {
        return toArticleResponseDTO(iArticleService.createArticle(articleRequestDTO.Headline(),
                articleRequestDTO.text(),
                articleRequestDTO.authorId()));
    }

    private static ArticleResponseDTO toArticleResponseDTO(Article article) {
        return new ArticleResponseDTO(article.getHeadline(), article.getText(), article.getAuthorId());
    }
}
