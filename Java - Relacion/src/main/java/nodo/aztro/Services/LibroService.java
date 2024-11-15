package nodo.aztro.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nodo.aztro.Models.Libro;
import nodo.aztro.Repositories.LibroByAuthorRepository;
import nodo.aztro.Repositories.LibroRepository;
import nodo.aztro.Dto.BooksByAuthor;
import nodo.aztro.Interfaces.BaseLibroService;

@Service
public class LibroService implements BaseLibroService {

    @Autowired
    private LibroRepository _libroRepository;

    @Autowired
    private LibroByAuthorRepository _libroByAuthorRepository;

    // Constructor por defecto
    public LibroService() {
    }

    public LibroService(LibroByAuthorRepository libroByAuthorRepository) {
        _libroByAuthorRepository = libroByAuthorRepository;
    }

    public LibroService(LibroRepository libroRepository) {
        _libroRepository = libroRepository;
    }

    public LibroService(LibroRepository libroRepository, LibroByAuthorRepository libroByAuthorRepository) {
        _libroRepository = libroRepository;
        _libroByAuthorRepository = libroByAuthorRepository;
    }

    // Metodos
    @Override
    public List<Libro> index() {
        return _libroRepository.index();
    }

    @Override
    public List<Libro> findTwoLibros(String titulo1, String titulo2) {
        return _libroRepository.findTwoLibros(titulo1, titulo2);
    }

    // DTO
    @Override 
    public List<BooksByAuthor> getAllBooksByAuthorId(Integer idAuthor) {
        List<BooksByAuthor> response = new ArrayList<BooksByAuthor>();
        response = _libroByAuthorRepository.findByAuthorId(idAuthor);
        return response;
    }

    @Override
    public List<BooksByAuthor> getAllBooksByAuthorName(String nameAuthor) {
        List<BooksByAuthor> response = new ArrayList<BooksByAuthor>();
        response = _libroByAuthorRepository.findByAuthorName(nameAuthor);
        return response;
    }
}