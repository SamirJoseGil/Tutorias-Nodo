package nodo.java.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import nodo.java.modelo.Personas;

public interface PersonaRepository extends CrudRepository<Personas, Long > {

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM PERSONA")
    List<Personas> findAll();

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM PERSONA WHERE id = :id")
    List<Personas> findById(@Param("id") int id);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM PERSONA WHERE nombre LIKE %:nombre%")
    List<Personas> findByName(@Param("nombre") String nombre);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM PERSONA WHERE apellido LIKE %:apellido%")
    List<Personas> findByLastName(@Param("apellido") String apellido);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM PERSONA WHERE correo LIKE %:correo%")
    List<Personas> findByEmail(@Param("correo") String correo); 

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM PERSONA WHERE documento LIKE %:documento%")
    List<Personas> findByDocument(@Param("documento") String documento);
}
