package nodo.bookCrud.services;

import java.util.Date;
import java.util.List;

import nodo.bookCrud.interfaces.BaseBookService;
import nodo.bookCrud.models.Book;
import nodo.bookCrud.repositories.BookRepository;

public class BookService implements BaseBookService {
    
    private BookRepository _bookRepository;

    public BookService(BookRepository bookRepository) {
        _bookRepository = bookRepository;
    }

    @Override
    public List<Book> Index() {
        return _bookRepository.Index();
    }

    @Override
    public List<Book> GetById(Integer Id) {
        return _bookRepository.GetById(Id);
    }

    @Override
    public List<Book> GetByName(String Name) {
        return _bookRepository.GetByName(Name);
    }

    @Override
    public List<Book> GetByISBN10(String ISBN10) {
        return _bookRepository.GetByISBN10(ISBN10);
    }

    @Override
    public List<Book> GetByISBN13(String ISBN13) {
        return _bookRepository.GetByISBN13(ISBN13);
    }   

    @Override
    public List<Book> GetByEdition(String Edition) {
        return _bookRepository.GetByEdition(Edition);
    }

    @Override
    public List<Book> GetByGenre(String Genre) {
        return _bookRepository.GetByGenre(Genre);
    }

    @Override
    public List<Book> GetByPublished(Date StartDate, Date EndDate) {
        return _bookRepository.GetByPublished(StartDate, EndDate);
    }

    @Override
    public Book saveAndFlush(Book book) {
        return _bookRepository.saveAndFlush(book);
    }

    @Override
    public Book updateBook(Integer Id, Book book) {
        List<Book> bookList = _bookRepository.GetById(Id);
        if (bookList.size() > 0) {
            Book bookToUpdate = bookList.get(0);

            bookToUpdate.setName(book.getName());
            bookToUpdate.setISBN10(book.getISBN10());
            bookToUpdate.setISBN13(book.getISBN13());
            bookToUpdate.setPublished(book.getPublished());
            bookToUpdate.setEdition(book.getEdition());
            bookToUpdate.setGenre(book.getGenre());

            return _bookRepository.saveAndFlush(bookToUpdate);
        }
        return null;
    }

    @Override
    public Book deleteBook(Integer Id) {
        List<Book> bookList = _bookRepository.GetById(Id);
        if (bookList.size() > 0) {
            Book bookToDelete = bookList.get(0);
            _bookRepository.delete(bookToDelete);
            return bookToDelete;
        }
        return null;
    }
}
