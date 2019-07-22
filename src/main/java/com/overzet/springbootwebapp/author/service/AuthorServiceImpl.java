package com.overzet.springbootwebapp.author.service;

import com.overzet.springbootwebapp.author.entity.Entity;
import com.overzet.springbootwebapp.author.model.Author;
import com.overzet.springbootwebapp.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public void addAuthor(Entity entity) {
        repository.save(entity);
    }

    public void deleteAuthor(Long id) {
        repository.deleteById(id);
    }

    public Entity findById(Long id) {
        Optional<Entity> result = repository.findById(id);
        Entity entity = null;
        if (result.isPresent()) {
            entity = result.get();
        } else {
            throw new RuntimeException("Did not find employee id: " + id);
        }
        return entity;
    }

    public Entity updateAuthor(Long id, Entity entity) {

        Optional<Entity> optionalAuthor = repository.findById(id);// Getting an optional from the DB with the help of JPA

        Entity entityFromDb = null;

        if (optionalAuthor.isPresent()) {// If there is something in the optional then do something

            entityFromDb = optionalAuthor.get();// Create a temporary 'entityFromDb' and fill it with what came out of the DB

            // Set the new values of firstName and lastName
            entityFromDb.setFirstName(entity.getFirstName());
            entityFromDb.setLastName(entity.getLastName());
            entityFromDb = repository.save(entityFromDb);// Save the new data to entity in the DB

        } else {
            throw new RuntimeException("Did not find employee id: " + id);
        }
        return entityFromDb;// Returns the new content from the DB

        //TODO remove all comments
    }
}
