package de.martinhaberl.safariguide.author.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    IAuthorService iAuthorService;

    public AuthorController(IAuthorService iAuthorService) {
        this.iAuthorService = iAuthorService;
    }

    public AuthorResponseDTO createAuthor(String name, String email) {
         return iAuthorService.createAuthor(name, email);
    }
}
