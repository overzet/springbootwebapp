package com.overzet.springbootwebapp.service;

import com.overzet.springbootwebapp.model.Author;
import com.overzet.springbootwebapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void updateAuthor(Author author) {
        authorRepository.save();
    }
}
