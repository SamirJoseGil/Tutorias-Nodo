package nodo.java.interfaces;

import java.util.List;
import nodo.java.modelo.Personas;

public interface BasePersonasService {

    Iterable<Personas> findAll();
    List<Personas> findById(int id);
    List<Personas> findByNombre(String nombre);
    List<Personas> findByApellido(String apellido);
    List<Personas> findByCorreo(String correo);
    List<Personas> findByDocumento(String documento);


    Personas addPersonas(Personas personas);
    Personas updatePersonas(int Id, Personas personas);
    Personas deletePersonas(int Id);
}
