package nodo.bookCrud.models;

import java.util.Date;
import jakarta.persistence.*;


@Entity
@Table(name="books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String Name;
    private String ISBN10;
    private String ISBN13;
    private Date Published;
    private String Edition;
    private String Genre;

    // Getters and Setters
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getISBN10() {
        return ISBN10;
    }
    public void setISBN10(String iSBN10) {
        ISBN10 = iSBN10;
    }
    public String getISBN13() {
        return ISBN13;
    }
    public void setISBN13(String iSBN13) {
        ISBN13 = iSBN13;
    }
    public Date getPublished() {
        return Published;
    }
    public void setPublished(Date published) {
        Published = published;
    }
    public String getEdition() {
        return Edition;
    }
    public void setEdition(String edition) {
        Edition = edition;
    }
    public String getGenre() {
        return Genre;
    }
    public void setGenre(String genre) {
        Genre = genre;
    }
}
