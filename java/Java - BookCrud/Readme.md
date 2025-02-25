# CRUD en Java - Ejemplo con un Libro

Este proyecto es un ejemplo de cómo implementar un CRUD (Create, Read, Update, Delete) en Java utilizando un modelo básico de libro. El objetivo es ilustrar la arquitectura MVC (Modelo-Vista-Controlador) y cómo se implementan los servicios, repositorios, interfaces y controladores en un CRUD.

## Arquitectura MVC

La arquitectura MVC divide la aplicación en tres componentes principales:

- **Modelo (Model)**: Representa la estructura de los datos de la aplicación. En este caso, es un objeto Java que contiene las propiedades del libro.
- **Vista (View)**: Es la interfaz de usuario. Aunque en este ejemplo no se incluye una vista específica (como una interfaz gráfica), puedes usar frameworks como JSP o Thymeleaf para mostrar la información.
- **Controlador (Controller)**: Es responsable de manejar las solicitudes de la vista, procesar los datos a través del servicio y devolver la respuesta adecuada.

## Modelo

El modelo define la estructura del libro. Aquí tienes un ejemplo básico de cómo se ve el modelo en Java.

```java
public class Book {
    private Integer id;
    private String name;
    private String ISBN10;
    private String ISBN13;
    private Date published;
    private String edition;
    private String genre;

    // Getters y Setters
}
``` 

Explicación
id: Identificador único del libro.
name: Nombre del libro.
ISBN10: Código ISBN de 10 caracteres.
ISBN13: Código ISBN de 13 caracteres.
published: Fecha en que el libro fue publicado.
edition: Edición del libro.
genre: Género del libro.
## Repositorio

El repositorio es responsable de interactuar con la base de datos. En este caso, podríamos usar JPA o Hibernate para gestionar las operaciones de CRUD con la base de datos.

```java
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM book")
    List<Book> Index();

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM book WHERE Id = :Id")
    List<Book> GetById(Integer Id);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM book WHERE Name LIKE %:Name%")
    List<Book> GetByName(String Name);
}
```

### Explicación

`CrudRepository`: Es una interfaz que proporciona métodos básicos para crear, leer, actualizar y eliminar registros en la base de datos.

`BookRepository`: Es la interfaz que extiende CrudRepository para el modelo Book, lo que permite realizar operaciones CRUD.

## Servicio
El servicio se encarga de contener la lógica del negocio. Aquí se implementan las funciones necesarias para operar con los libros.

```java
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }
}
```

### Explicación

`findAll():` Devuelve todos los libros de la base de datos.

`findById():` Busca un libro por su id.

`save():` Guarda o actualiza un libro.

`deleteById():` Elimina un libro de la base de datos por su id.

## Interfaz (Interface)

En este contexto, la interfaz se refiere a las interfaces del repositorio o del servicio que definen los métodos que deben implementarse. Por ejemplo, el repositorio y el servicio contienen interfaces para interactuar con los datos.

```java

import java.util.Date;
import java.util.List;
import nodo.bookCrud.models.Book;

public interface BaseBookService {
    
    List<Book> Index();
    List<Book> GetById(Integer Id);
    List<Book> GetByName(String Name);
    List<Book> GetByISBN10(String ISBN10);
    List<Book> GetByISBN13(String ISBN13);
    List<Book> GetByEdition(String Edition);
    List<Book> GetByGenre(String Genre);
    List<Book> GetByPublished(Date StartDate, Date EndDate);
    
    Book saveAndFlush(Book book);
    Book updateBook(Integer Id, Book book);
    Book deleteBook(Integer Id);
}
```

## Controlador
El controlador maneja las solicitudes HTTP y llama a los métodos del servicio para realizar las operaciones CRUD.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Iterable<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.findById(id).orElse(null);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
        book.setId(id);
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteById(id);
    }
}
```


### Explicación

`@GetMapping:` Mapea una solicitud GET a /books para obtener todos los libros.

`@GetMapping("/{id}"):` Mapea una solicitud GET para obtener un libro por su id.

`@PostMapping:` Mapea una solicitud POST para crear un nuevo libro.

`@PutMapping("/{id}"):` Mapea una solicitud PUT para actualizar un libro existente.

`@DeleteMapping("/{id}"):` Mapea una solicitud DELETE para eliminar un libro.

## Conclusión

Este proyecto de CRUD en Java sigue la arquitectura MVC y utiliza repositorios, servicios y controladores para gestionar las operaciones de los libros. Puedes extender este ejemplo para cualquier otro modelo, ya sea para una tienda, biblioteca o cualquier otra aplicación.