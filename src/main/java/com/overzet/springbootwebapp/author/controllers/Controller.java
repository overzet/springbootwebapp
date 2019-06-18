package com.overzet.springbootwebapp.author.controllers;

import com.overzet.springbootwebapp.author.entity.Entity;
import com.overzet.springbootwebapp.author.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authors")
public class Controller {

    @Autowired
    private ServiceImpl authorServiceImpl;

    @GetMapping()
    public List<Entity> authorList() {
        return authorServiceImpl.authorList();
    }

    @PostMapping()
    public void addAuthor(@RequestBody Entity entity) {
        authorServiceImpl.addAuthor(entity);
    }

    @GetMapping("{id}")
    public Entity findById(@PathVariable Long id) {
        return authorServiceImpl.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        authorServiceImpl.deleteAuthor(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Entity> updateAuthor(@PathVariable Long id, @RequestBody Entity entity) {

        return new ResponseEntity<>(authorServiceImpl.updateAuthor(id, entity), HttpStatus.OK);

    }


}
