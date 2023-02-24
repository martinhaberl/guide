package de.martinhaberl.safariguide.author;

import de.martinhaberl.safariguide.author.control.Author;
import de.martinhaberl.safariguide.author.control.AuthorService;
import de.martinhaberl.safariguide.author.entity.AuthorEntity;
import de.martinhaberl.safariguide.author.entity.AuthorEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AuthorServiceUnitTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void createAuthorReturnsResponseDTOwithIdAndNameAndEMail() {

        AuthorEntityRepository authorEntityRepositoryMock = mock(AuthorEntityRepository.class);
        AuthorService authorService = new AuthorService(authorEntityRepositoryMock);
        AuthorEntity authorEntityStub = new AuthorEntity("Ron Weasley", "iron.weasel@hogwards.edu");

        //when(authorEntityRepositoryMock.save(authorEntity)).thenReturn(authorEntityStub);
        when(authorEntityRepositoryMock.save(any())).thenReturn(authorEntityStub);

        Author actualAuthor = authorService.createAuthor("Ron Weasley", "iron.weasel@hogwards.edu");

        assertNotNull(actualAuthor);
        assertThat(actualAuthor).isInstanceOf(Author.class);
        assertThat(actualAuthor.getId()).isNotNull();
        assertEquals("Ron Weasley",actualAuthor.getName());
    }
}