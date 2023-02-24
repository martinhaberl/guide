package de.martinhaberl.safariguide.author;

import de.martinhaberl.safariguide.author.boundary.AuthorController;
import de.martinhaberl.safariguide.author.boundary.AuthorRequestDTO;
import de.martinhaberl.safariguide.author.boundary.AuthorResponseDTO;
import de.martinhaberl.safariguide.author.control.IAuthorService;
import de.martinhaberl.safariguide.author.control.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthorControllerUnitTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void createAuthorReturnsResponseDTOwithNameAndEMail() {

        IAuthorService iAuthorServiceMock = mock(IAuthorService.class);
        AuthorController authorController = new AuthorController(iAuthorServiceMock);
        AuthorRequestDTO authorRequestDTO = new AuthorRequestDTO("Ron Weasley", "iron.weasle@hogwards.edu");

        UUID uuid = UUID.randomUUID();
        Author author = new Author(uuid, Instant.now(), Instant.now(), 0,"Ron Weasley","iron.weasle@hogwards.edu");

        when(iAuthorServiceMock.createAuthor(anyString(), anyString())).thenReturn(author);

        AuthorResponseDTO actualAuthorResponseDTO = authorController.createAuthor(authorRequestDTO);

        assertNotNull(actualAuthorResponseDTO);
        assertEquals(uuid, actualAuthorResponseDTO.id());
        assertEquals(authorRequestDTO.name(), actualAuthorResponseDTO.name());
        assertEquals(authorRequestDTO.emailAddress(), actualAuthorResponseDTO.emailAddress());
    }
}
