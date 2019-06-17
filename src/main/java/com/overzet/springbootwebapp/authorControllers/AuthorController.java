package com.overzet.springbootwebapp.authorControllers;

import com.overzet.springbootwebapp.authorEntity.AuthorEntity;
import com.overzet.springbootwebapp.authorServiceImpl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authors")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorServiceImpl;

    @GetMapping()
    public List<AuthorEntity> authorList() {
        return authorServiceImpl.authorList();
    }

    @PostMapping()
    public void addAuthor(@RequestBody AuthorEntity authorEntity) {
        authorServiceImpl.addAuthor(authorEntity);
    }

    @GetMapping("{id}")
    public AuthorEntity findById(@PathVariable Long id) {
        return authorServiceImpl.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        authorServiceImpl.deleteAuthor(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<AuthorEntity> updateAuthor(@PathVariable Long id, @RequestBody AuthorEntity authorEntity) {

        return new ResponseEntity<>(authorServiceImpl.updateAuthor(id, authorEntity), HttpStatus.OK);

    }


}
