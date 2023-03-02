package de.martinhaberl.safariguide.author.boundary;

import de.martinhaberl.safariguide.author.control.Author;
import de.martinhaberl.safariguide.author.control.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {


    IAuthorService iAuthorService;

    @Autowired
    public AuthorController(IAuthorService injectedIAuthorService) {
        this.iAuthorService = injectedIAuthorService;
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponseDTO createAuthor(@RequestBody AuthorRequestDTO authorRequestDTO) {
        return toResponseDTO(iAuthorService.createAuthor(authorRequestDTO.name(), authorRequestDTO.emailAddress()));
    }

    @GetMapping("/authors")
    public List<AuthorResponseDTO> getAuthors() {
        return iAuthorService.getAuthors().stream().map(AuthorController::toResponseDTO).toList();
    }

    private static AuthorResponseDTO toResponseDTO(Author author) {
        return new AuthorResponseDTO(author.getId(), author.getName(), author.getEmailAddress());
    }
}
