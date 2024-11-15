package nodo.aztro.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nodo.aztro.Repositories.AuthorRepository;
import nodo.aztro.Interfaces.BaseAuthorService;
import nodo.aztro.Models.Author;

@Service
public class AuthorService implements BaseAuthorService{
    

    @Autowired
    private AuthorRepository _authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        _authorRepository = authorRepository;
    }

    // Metodos
    public List<Author> index() {
        return _authorRepository.index();
    }
}
