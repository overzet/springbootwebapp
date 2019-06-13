package com.overzet.springbootwebapp.controllers;

import com.overzet.springbootwebapp.model.Author;
import com.overzet.springbootwebapp.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorServiceImpls;

    @GetMapping(value = "authors")
    public List<Author> authorList() {
        return authorServiceImpls.authorList();
    }

    @PostMapping(value = "authors/add")
    public void addAuthor(@RequestBody Author author) {
        authorServiceImpls.addAuthor(author);
    }

    @PutMapping(value = "authors/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        authorServiceImpls.updateAuthor(id, author);

        return new ResponseEntity<Author>(author, HttpStatus.OK);

    }

}
