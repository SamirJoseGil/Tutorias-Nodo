package nodo.java.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "personas")
public class Personas {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String Nombre; 
    private String Apellido;
    private String Correo;
    private String Documento;




    // Getters y Setters
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        Apellido = apellido;
    }
    public String getCorreo() {
        return Correo;
    }
    public void setCorreo(String correo) {
        Correo = correo;
    }
    public String getDocumento() {
        return Documento;
    }
    public void setDocumento(String documento) {
        Documento = documento;
    }



    

}
