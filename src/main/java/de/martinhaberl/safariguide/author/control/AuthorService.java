package de.martinhaberl.safariguide.author.control;

import de.martinhaberl.safariguide.author.entity.AuthorEntity;
import de.martinhaberl.safariguide.author.entity.AuthorEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements IAuthorService {

    private final AuthorEntityRepository authorEntityRepository;

    @Autowired
    public AuthorService(AuthorEntityRepository authorEntityRepository) {
        this.authorEntityRepository = authorEntityRepository;
    }

    @Override
    public Author createAuthor(String name, String emailAddress) {
        AuthorEntity authorEntity = new AuthorEntity(name, emailAddress);
        AuthorEntity savedAuthorEntity = authorEntityRepository.save(authorEntity);

        return toAuthor(savedAuthorEntity);
    }

    private Author toAuthor(AuthorEntity savedAuthorEntity) {
        Author author = new Author();
        author.setId(savedAuthorEntity.getId());
        author.setCreatedAt(savedAuthorEntity.getCreatedAt());
        author.setModifiedAt(savedAuthorEntity.getModifiedAt());
        author.setVersion(savedAuthorEntity.getVersion());
        author.setName(savedAuthorEntity.getName());
        author.setEmailAddress(savedAuthorEntity.getEmailAddress());
        return author;
    }
}
