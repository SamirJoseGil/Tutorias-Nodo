package nodo.java.models;

import java.util.ArrayList;
import java.util.List;

// Clase genérica que contiene una lista de objetos genéricos
public class CajaList<T> {
    private List<T> contenido;

    public CajaList() {
        this.contenido = new ArrayList<>();
    }

    public void agregarElemento(T elemento) {
        contenido.add(elemento);
    }

    public List<T> obtenerContenido() {
        return contenido;
    }

    public void eliminarElemento(T elemento) {
        contenido.remove(elemento);
    }
}