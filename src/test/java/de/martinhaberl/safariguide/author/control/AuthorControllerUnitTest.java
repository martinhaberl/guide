package de.martinhaberl.safariguide.author.control;

import de.martinhaberl.safariguide.author.boundary.AuthorController;
import de.martinhaberl.safariguide.author.boundary.AuthorResponseDTO;
import de.martinhaberl.safariguide.author.boundary.IAuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
    void createAuthor() {

        IAuthorService iAuthorService = mock(IAuthorService.class);
        AuthorController authorController = new AuthorController(iAuthorService);
        when(iAuthorService.createAuthor(anyString(), anyString())).thenReturn(new AuthorResponseDTO(UUID.randomUUID(),"Ron Weasley","iron.weasle@hogwards.edu"));

        AuthorResponseDTO actualAuthorResponseDTO = authorController.createAuthor("Ron Weasley", "iron.weasle@hogwards.com");

        assertNotNull(actualAuthorResponseDTO);
        assertEquals("Ron Weasley", actualAuthorResponseDTO.name());
        assertEquals("iron.weasle@hogwards.edu", actualAuthorResponseDTO.email());

    }
}
