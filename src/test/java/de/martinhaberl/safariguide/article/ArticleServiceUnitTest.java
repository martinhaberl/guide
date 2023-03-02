package de.martinhaberl.safariguide.article;

import de.martinhaberl.safariguide.article.control.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArticleServiceUnitTest {

    @BeforeEach
    void setUp() {
    }

/*    @Test
    void createArticleReturnsResponseDTOwithArticleId_Heading_AuthorsId() {

        ArticleEntityRepository articleEntityRepositoryMock = mock(ArticleEntityRepository.class);
        ArticleService articleService = new ArticleService(ArticleEntityRepository);

        UUID authorId = UUID.randomUUID();
        ArticleEntity articleEntityStub = new ArticleEntity("Dining downtown", "Where to go, what to choose, who to meet. Check out for more.", authorId);

        when(articleEntityRepositoryMock.save(any(ArticleEntity.class))).thenReturn(articleEntityStub);

        Article actualArticle = articleService.createArticle("Dining downtown", "Where to go, what to choose, who to meet. Check out for more.", authorId);

        assertNotNull(actualArticle);
        assertThat(actualArticle).isInstanceOf(Article.class);
        assertThat(actualArticle.getId()).isNotNull();
        assertEquals("Dining downtown", actualArticle.getName());
        assertEquals(authorId, actualArticle.getId());
    }*/
}
