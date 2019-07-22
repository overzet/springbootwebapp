package com.overzet.springbootwebapp.author.controllers;

import com.overzet.springbootwebapp.author.model.Author;
import com.overzet.springbootwebapp.author.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorServiceImpl;

    @GetMapping("/authors")
    public Collection<Author> getAllAuthors() {
        return authorServiceImpl.findAll();
    }

}
