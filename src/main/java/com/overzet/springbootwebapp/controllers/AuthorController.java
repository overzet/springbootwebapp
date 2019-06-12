package com.overzet.springbootwebapp.controllers;

import com.overzet.springbootwebapp.model.Author;
import com.overzet.springbootwebapp.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorServiceImpls;

    @GetMapping("authors")
    public List<Author> authorList() {
        return authorServiceImpls.authorList();
    }

    @PostMapping("authors/add")
    public void addAuthor(@RequestBody Author author) {
        authorServiceImpls.addAuthor(author);
    }

    @PutMapping(value = "/authors/{id}")
    public void updateAuthor(@PathVariable Long id, @Valid @RequestBody String firstName, String lastName) {
        authorServiceImpls.updateAuthor();


    }

}
