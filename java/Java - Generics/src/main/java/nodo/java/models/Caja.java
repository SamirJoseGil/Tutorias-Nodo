package nodo.java.models;

// Definición de la clase genérica
public class Caja<T> {
    
    private T contenido;

    // Constructor
    public Caja(T contenido) {
        this.contenido = contenido;
    }

    // Método para obtener el contenido
    public T getContenido() {
        return contenido;
    }

    // Método para establecer el contenido
    public void setContenido(T contenido) {
        this.contenido = contenido;
    }
}