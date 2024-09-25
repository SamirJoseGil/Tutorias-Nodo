package nodo.java.models;

// Clase genérica que representa un par clave-valor
public class Par<v, k> {
    private k valor;
    private v clave;


    public Par(v clave, k valor) {
        this.clave = clave;
        this.valor = valor;
    }


    // Getters y Setters
    public v getClave() {
        return clave;
    }

    public void setClave(v clave) {
        this.clave = clave;
    }

    public k getValor() {
        return valor;
    }

    public void setValor(k valor) {
        this.valor = valor;
    }
}