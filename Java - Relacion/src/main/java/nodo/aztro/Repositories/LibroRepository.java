package nodo.aztro.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import nodo.aztro.Models.Libro;

public interface LibroRepository extends CrudRepository<Libro, Integer> {

    @Query(
        nativeQuery = true,
        value =  "SELECT * FROM Libro")
    List<Libro> index();

    @Query(
        nativeQuery = true,
        value =  "SELECT * FROM Libro WHERE titulo LIKE %:titulo1% OR titulo LIKE %:titulo2%")
    List<Libro> findTwoLibros (String titulo1, String titulo2);
}