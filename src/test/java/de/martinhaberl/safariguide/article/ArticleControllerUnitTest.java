package de.martinhaberl.safariguide.article;

import de.martinhaberl.safariguide.article.boundary.ArticleController;
import de.martinhaberl.safariguide.article.boundary.ArticleRequestDTO;
import de.martinhaberl.safariguide.article.boundary.ArticleResponseDTO;
import de.martinhaberl.safariguide.article.control.Article;
import de.martinhaberl.safariguide.article.control.IArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ArticleControllerUnitTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void createAuthorReturnsResponseDTOwith_Headline_Text_AuthorId() {
        IArticleService iArticleServiceMock = mock(IArticleService.class);
        ArticleController articleController = new ArticleController(iArticleServiceMock);

        UUID authorId  = UUID.randomUUID();
        ArticleRequestDTO articleRequestDTO = new ArticleRequestDTO("Dining downtown", "Where to go, what to choose, who to meet. Check out for more.", authorId);

        UUID uuid = UUID.randomUUID();
        Article article = new Article(uuid, Instant.now(), Instant.now(), 0,"Dining downtown", "Where to go, what to choose, who to meet. Check out for more.", authorId);

        when(iArticleServiceMock.createArticle(anyString(), anyString(), any(UUID.class))).thenReturn(article);

        ArticleResponseDTO actualArticleResponseDTO = articleController.createArticle(articleRequestDTO);

        assertNotNull(actualArticleResponseDTO);
        assertEquals(articleRequestDTO.Headline(), actualArticleResponseDTO.headline());
        assertEquals(articleRequestDTO.text(), actualArticleResponseDTO.text());
        assertEquals(articleRequestDTO.authorId(), actualArticleResponseDTO.author());
        //verify(iArticleServiceMock, times(1)).createArticle("Dining downtown", "Where to go, what to choose, who to meet. Check out for more.", uuid);
    }
}
