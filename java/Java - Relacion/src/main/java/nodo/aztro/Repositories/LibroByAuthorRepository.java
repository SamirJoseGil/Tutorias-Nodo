package nodo.aztro.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import nodo.aztro.Dto.BooksByAuthor;

public interface LibroByAuthorRepository extends CrudRepository<BooksByAuthor, Long> {

    @Query(nativeQuery = true, 
        value = "SELECT " +
                "l.id AS id_libro, l.titulo AS titulo_libro, " +
                "au.name AS nombre_autor " +
                "FROM Author au " +
                "JOIN Libro l ON l.author_id = au.id " +
                "WHERE au.id = :idAuthor")
    List<BooksByAuthor> findByAuthorId(@Param("idAuthor") Integer idAuthor);

    @Query(nativeQuery = true, 
        value = "SELECT " +
                "l.id AS id_libro, l.titulo AS titulo_libro, " +
                "au.name AS nombre_autor " +
                "FROM Author au " +
                "JOIN Libro l ON l.author_id = au.id " +
                "WHERE au.name = :nameAuthor")
    List<BooksByAuthor> findByAuthorName(@Param("nameAuthor") String nameAuthor);

}