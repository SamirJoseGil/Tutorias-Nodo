package nodo.aztro.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import nodo.aztro.Models.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    @Query(
        nativeQuery = true,
        value =  "SELECT * FROM Author")
    List<Author> index();
    
}
