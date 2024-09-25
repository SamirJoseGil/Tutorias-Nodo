package nodo.java.services;

import java.util.List;

import nodo.java.modelo.Personas;
import nodo.java.repositories.PersonaRepository;
import nodo.java.interfaces.BasePersonasService;

public class PersonasService implements BasePersonasService {

    private PersonaRepository _personaRepository;

    public PersonasService(PersonaRepository personasRepository) {
        _personaRepository = personasRepository;
    }

    @Override
    public Iterable<Personas> findAll() {
        return _personaRepository.findAll();
    }

    @Override
    public List<Personas> findById(int id) {
        return _personaRepository.findById(id);
    }

    @Override
    public List<Personas> findByNombre(String nombre) {
        return _personaRepository.findByName(nombre);
    }

    @Override
    public List<Personas> findByApellido(String apellido) {
        return _personaRepository.findByLastName(apellido);
    }

    @Override
    public List<Personas> findByCorreo(String correo) {
        return _personaRepository.findByEmail(correo);
    }

    @Override
    public List<Personas> findByDocumento(String documento) {
        return _personaRepository.findByDocument(documento);
    }
 
    @Override
    public Personas addPersonas(Personas personas) {
        return _personaRepository.save(personas);
    }

    @Override
    public Personas updatePersonas(int Id, Personas personas) {
        List<Personas> personasList = _personaRepository.findById(Id);
        if (personasList.size() > 0)
        {
            Personas personasToUpdate = personasList.get(0);

            personasToUpdate.setNombre(personas.getNombre());
            personasToUpdate.setApellido(personas.getApellido());
            personasToUpdate.setCorreo(personas.getCorreo());
            personasToUpdate.setDocumento(personas.getDocumento());

            return _personaRepository.save(personasToUpdate);
        }
        return null;
    }

    @Override
    public Personas deletePersonas(int Id) {
        List<Personas> personasList = _personaRepository.findById(Id);
        if (personasList.size() > 0)
        {
            Personas personasToDelete = personasList.get(0);

            _personaRepository.delete(personasToDelete);

            return personasToDelete;
        }
        return null;
    }
}
