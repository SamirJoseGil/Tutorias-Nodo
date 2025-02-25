package nodo.aztro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nodo.aztro.Repositories.AuthorRepository;
import nodo.aztro.Services.AuthorService;
import nodo.aztro.Models.Author;

@RestController
@RequestMapping("/author")
@CrossOrigin(origins = "*")
public class AuthorController {
    
    @Autowired
    private AuthorRepository _authorRepository;

    // Metodos
    @GetMapping("/index")
    public ResponseEntity<List<Author>> index() {
        List<Author> authors = new AuthorService(_authorRepository).index();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

}
