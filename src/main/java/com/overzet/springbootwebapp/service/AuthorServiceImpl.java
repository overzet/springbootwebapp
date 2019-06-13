package com.overzet.springbootwebapp.service;

import com.overzet.springbootwebapp.model.Author;
import com.overzet.springbootwebapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {


    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> authorList() {
        return authorRepository.findAll();
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Long id, Author author) {

        /*
            The method findById will give you an optional and this optional can contain or not an author
            Verify if the optional contains an author by doing if(authorFromDb.isPresent)
            If it's true then retrieve the author by doing authorFromDB.get()
         */
        Optional<Author> authorFromDb = authorRepository.findById(id);

        if (authorFromDb.isPresent()) {
            Author authorDb = authorFromDb.get();
            authorDb.setFirstName(author.getFirstName());
            authorDb.setLastName(author.getLastName());

            authorRepository.save(authorDb);
        }
    }
}
