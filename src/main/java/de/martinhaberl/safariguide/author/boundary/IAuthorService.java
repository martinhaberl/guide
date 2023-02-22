package de.martinhaberl.safariguide.author.boundary;


public interface IAuthorService {
    AuthorResponseDTO createAuthor(String name, String email);
}
