package nodo.bookCrud.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nodo.bookCrud.models.Book;
import nodo.bookCrud.repositories.BookRepository;
import nodo.bookCrud.services.BookService;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {
    
    @Autowired
    private BookRepository _bookRepository;

    @PostMapping("/createbook")
    public ResponseEntity<Book> createBook(@RequestBody Book book) 
    {
        try {
            Book creaBook = new BookService(_bookRepository).saveAndFlush(book);

            return new ResponseEntity<>(creaBook, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestParam Integer Id, Book book)
    {
        try {
            Book updateBook = new BookService(_bookRepository).updateBook(Id, book);

            return new ResponseEntity<>(updateBook, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Book> deleteBook(@RequestParam Integer Id)
    {
        try {
            new BookService(_bookRepository).deleteBook(Id);

            return new ResponseEntity<>( HttpStatus.OK );
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/index")
    public ResponseEntity<List<Book>> Index()
    {
        try {
            List<Book> books = new BookService(_bookRepository).Index();

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<List<Book>> GetById(@RequestParam Integer Id)
    {
        try {
            List<Book> books = new BookService(_bookRepository).GetById(Id);

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<List<Book>> GetByName(@RequestParam String Name)
    {
        try {
            List<Book> books = new BookService(_bookRepository).GetByName(Name);

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/getByISBN10")
    public ResponseEntity<List<Book>> GetByISBN10(@RequestParam String ISBN10)
    {
        try {
            List<Book> books = new BookService(_bookRepository).GetByISBN10(ISBN10);

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/getByISBN13")
    public ResponseEntity<List<Book>> GetByISBN13(@RequestParam String ISBN13)
    {
        try {
            List<Book> books = new BookService(_bookRepository).GetByISBN13(ISBN13);

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/getByEdition")
    public ResponseEntity<List<Book>> GetByEdition(@RequestParam String Edition)
    {
        try {
            List<Book> books = new BookService(_bookRepository).GetByEdition(Edition);

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/getByGenre")
    public ResponseEntity<List<Book>> GetByGenre(@RequestParam String Genre)
    {
        try {
            List<Book> books = new BookService(_bookRepository).GetByGenre(Genre);

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/getByPublished")
    public ResponseEntity<List<Book>> GetByPublished(@RequestParam Date StartDate, Date EndDate)
    {
        try {
            List<Book> books = new BookService(_bookRepository).GetByPublished(StartDate, EndDate);

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }
}