package nodo.aztro.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BooksByAuthor {

    @Id
    private Long idLibro;
    private String tituloLibro;
    private String nombreAutor;

    // Getters and Setters
    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
}