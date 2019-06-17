package com.overzet.springbootwebapp.service;

import com.overzet.springbootwebapp.domainmodel.Author;
import com.overzet.springbootwebapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository theAuthorRepository) {
        authorRepository = theAuthorRepository;

    }

    public List<Author> authorList() {
        return authorRepository.findAll();
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public Author findById(Long id) {
        Optional<Author> result = authorRepository.findById(id);
        Author author = null;
        if (result.isPresent()) {
            author = result.get();
        } else {
            throw new RuntimeException("Did not find employee id: " + id);
        }
        return author;
    }

    public Author updateAuthor(Long id, Author author) {

        Optional<Author> optionalAuthor = authorRepository.findById(id);// Getting an optional from the DB with the help of JPA

        Author authorFromDb = null;

        if (optionalAuthor.isPresent()) {// If there is something in the optional then do something

            authorFromDb = optionalAuthor.get();// Create a temporary 'authorFromDb' and fill it with what came out of the DB

            System.out.println("Author coming from database before update : " + authorFromDb);// This shows the old content from the DB

            // Set the new values of firstName and lastName
            authorFromDb.setFirstName(author.getFirstName());
            authorFromDb.setLastName(author.getLastName());
            authorFromDb = authorRepository.save(authorFromDb);// Save the new data to author in the DB

            System.out.println("Author coming from database after update : " + author);// This shows the new content from the DB

        } else {
            throw new RuntimeException("Did not find employee id: " + id);
        }
        return authorFromDb;// Returns the new content from the DB

        //TODO remove all comments
    }
}
