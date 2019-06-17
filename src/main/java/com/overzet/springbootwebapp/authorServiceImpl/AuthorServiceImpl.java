package com.overzet.springbootwebapp.authorServiceImpl;

import com.overzet.springbootwebapp.authorEntity.AuthorEntity;
import com.overzet.springbootwebapp.authorRepository.AuthorRepository;
import com.overzet.springbootwebapp.authorService.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }

    public List<AuthorEntity> authorList() {
        return authorRepository.findAll();
    }

    public void addAuthor(AuthorEntity authorEntity) {
        authorRepository.save(authorEntity);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public AuthorEntity findById(Long id) {
        Optional<AuthorEntity> result = authorRepository.findById(id);
        AuthorEntity authorEntity = null;
        if (result.isPresent()) {
            authorEntity = result.get();
        } else {
            throw new RuntimeException("Did not find employee id: " + id);
        }
        return authorEntity;
    }

    public AuthorEntity updateAuthor(Long id, AuthorEntity authorEntity) {

        Optional<AuthorEntity> optionalAuthor = authorRepository.findById(id);// Getting an optional from the DB with the help of JPA

        AuthorEntity authorEntityFromDb = null;

        if (optionalAuthor.isPresent()) {// If there is something in the optional then do something

            authorEntityFromDb = optionalAuthor.get();// Create a temporary 'authorEntityFromDb' and fill it with what came out of the DB

            // Set the new values of firstName and lastName
            authorEntityFromDb.setFirstName(authorEntity.getFirstName());
            authorEntityFromDb.setLastName(authorEntity.getLastName());
            authorEntityFromDb = authorRepository.save(authorEntityFromDb);// Save the new data to authorEntity in the DB

        } else {
            throw new RuntimeException("Did not find employee id: " + id);
        }
        return authorEntityFromDb;// Returns the new content from the DB

        //TODO remove all comments
    }
}
