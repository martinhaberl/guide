package de.martinhaberl.safariguide.author;

import de.martinhaberl.safariguide.author.boundary.AuthorResponseDTO;
import de.martinhaberl.safariguide.author.boundary.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements IAuthorService{

    private IAuthorRepository iAuthorRepository;

    @Autowired
    public AuthorService(IAuthorRepository iAuthorRepository){
        this.iAuthorRepository = iAuthorRepository;
    }


    @Override
    public AuthorResponseDTO createAuthor(String name, String email) {
        return null;
    }
}
