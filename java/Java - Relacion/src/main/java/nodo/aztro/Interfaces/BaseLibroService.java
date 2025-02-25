package nodo.aztro.Interfaces;

import java.util.List;

import nodo.aztro.Dto.BooksByAuthor;
import nodo.aztro.Models.Libro;

public interface BaseLibroService {

    List<Libro> index();
    List<Libro> findTwoLibros (String titulo1, String titulo2);



    // Dto
    List<BooksByAuthor> getAllBooksByAuthorId(Integer idAuthor);
    List<BooksByAuthor> getAllBooksByAuthorName(String nameAuthor);
}
