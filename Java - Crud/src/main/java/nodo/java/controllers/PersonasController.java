package nodo.java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nodo.java.repositories.PersonaRepository;
import nodo.java.services.PersonasService;
import nodo.java.modelo.*;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "*")
public class PersonasController {
    
    @Autowired
    private PersonaRepository _personasRepository;

    @PostMapping("/add")
    public ResponseEntity<Personas> addPersona(@RequestBody Personas personas)
    {
        try {
            Personas creatPersona = new PersonasService(_personasRepository).addPersonas(personas);
            return new ResponseEntity<>(creatPersona, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Personas> updatePersona(@PathVariable int id, @RequestBody Personas personas)
    {
        try {
            Personas updatePersona = new PersonasService(_personasRepository).updatePersonas(id, personas);
            return new ResponseEntity<>(updatePersona, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Personas> deletePersona(@PathVariable int id)
    {
        try {
            Personas deletePersona = new PersonasService(_personasRepository).deletePersonas(id);
            return new ResponseEntity<>(deletePersona, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Personas>> getAllPersonas()
    {
        try {
            Iterable<Personas> personas = new PersonasService(_personasRepository).findAll();
            return new ResponseEntity<>(personas, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Iterable<Personas>> getPersonaById(@PathVariable int id)
    {
        try {
            var response = new PersonasService(_personasRepository).findById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Iterable<Personas>> getPersonaByNombre(@PathVariable String nombre)
    {
        try {
            Iterable<Personas> personas = new PersonasService(_personasRepository).findByNombre(nombre);
            return new ResponseEntity<>(personas, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<Iterable<Personas>> getPersonaByApellido(@PathVariable String apellido)
    {
        try {
            Iterable<Personas> personas = new PersonasService(_personasRepository).findByApellido(apellido);
            return new ResponseEntity<>(personas, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<Iterable<Personas>> getPersonaByCorreo(@PathVariable String correo)
    {
        try {
            Iterable<Personas> personas = new PersonasService(_personasRepository).findByCorreo(correo);
            return new ResponseEntity<>(personas, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/documento/{documento}")
    public ResponseEntity<Iterable<Personas>> getPersonaByDocumento(@PathVariable String documento)
    {
        try {
            Iterable<Personas> personas = new PersonasService(_personasRepository).findByDocumento(documento);
            return new ResponseEntity<>(personas, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
