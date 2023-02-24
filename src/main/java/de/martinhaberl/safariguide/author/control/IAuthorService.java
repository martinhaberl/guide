package de.martinhaberl.safariguide.author.control;


import java.util.List;

public interface IAuthorService {
    Author createAuthor(String name, String emailAddress);

    List<Author> getAuthors();
}
