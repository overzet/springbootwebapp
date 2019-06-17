package com.overzet.springbootwebapp.controllers;

import com.overzet.springbootwebapp.domainmodel.Author;
import com.overzet.springbootwebapp.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authors")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorServiceImpls;

    @GetMapping()
    public List<Author> authorList() {
        return authorServiceImpls.authorList();
    }

    @PostMapping()
    public void addAuthor(@RequestBody Author author) {
        authorServiceImpls.addAuthor(author);
    }

    @GetMapping("{id}")
    public Author findById(@PathVariable Long id) {
        return authorServiceImpls.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        authorServiceImpls.deleteAuthor(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {

        return new ResponseEntity<>(authorServiceImpls.updateAuthor(id, author), HttpStatus.OK);

    }


}
