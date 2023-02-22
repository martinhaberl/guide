package de.martinhaberl.safariguide.author.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    @Autowired
    IAuthorService iAuthorService;

    public AuthorController(IAuthorService iAuthorService) {
        this.iAuthorService = iAuthorService;
    }
    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponseDTO createAuthor(@RequestBody AuthorRequestDTO authorRequest) {
         return iAuthorService.createAuthor(authorRequest.name(), authorRequest.email());
    }
}
