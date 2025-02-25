package nodo.java.models;

import jakarta.persistence.*;

@Entity
@Table(name = "caja_string_entity")
public class CajaStringEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contenido")
    private String contenido;

    // Constructor vacío requerido por JPA
    public CajaStringEntity() {
    }

    public CajaStringEntity(String contenido) {
        this.contenido = contenido;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}