package de.martinhaberl.safariguide.author.boundary;

import de.martinhaberl.safariguide.author.control.Author;
import de.martinhaberl.safariguide.author.control.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    IAuthorService iAuthorService;

    public AuthorController(IAuthorService iAuthorService) {
        this.iAuthorService = iAuthorService;
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponseDTO createAuthor(@RequestBody AuthorRequestDTO authorRequestDTO) {
        return toResponseDTO(iAuthorService.createAuthor(authorRequestDTO.name(), authorRequestDTO.emailAddress()));
    }

    private AuthorResponseDTO toResponseDTO(Author author) {
        return new AuthorResponseDTO(author.getId(), author.getName(), author.getEmailAddress());
    }
}
