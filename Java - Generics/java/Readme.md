# Java Generics con Spring Boot

### Descripción

Este proyecto está diseñado para enseñar el concepto de **Generics en Java** dentro de una aplicación práctica usando **Spring Boot**. Los **generics** permiten escribir código que puede manejar diferentes tipos de datos sin necesidad de duplicar la lógica. A lo largo del proyecto, implementamos varios ejemplos para demostrar cómo funcionan los generics y cómo pueden ser utilizados en aplicaciones cotidianas.


## 1. ¿Qué son los Generics?

Los **Generics** en Java permiten definir clases, interfaces y métodos que trabajan con tipos parametrizados. Esto significa que puedes escribir código que sea reutilizable y seguro en cuanto a tipos, sin tener que hacer conversiones explícitas.

- **Clase Genérica**: Una clase que acepta parámetros de tipo.
- **Método Genérico**: Un método que acepta o retorna tipos genéricos.
- **Comodines**: Parámetros genéricos que permiten mayor flexibilidad (por ejemplo, `List<?>`).


#  Ejemplos Implementados

## `Caja<T>`

La clase `Caja<T>` es un ejemplo simple de una clase genérica que almacena un objeto de cualquier tipo `T`. 

```java
public class Caja<T> {

    private T contenido;
    // T es la forma de definir el valor generico

    // Constructor
    public Caja(T contenido) {
        this.contenido = contenido;
    }

    // Getters and setters
    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }
}
```
### Propósito:

Almacena un solo objeto genérico. Permite que la clase sea flexible y reutilizable.

## `CajaList<T>`
La clase `CajaList<T>` es una colección genérica que permite manejar múltiples objetos de tipo `T`.

```java
public class CajaList<T> {

    private List<T> contenido;
    // Lista de cualquier objeto

    public CajaList() {
        this.contenido = new ArrayList<>();
    }
    // Constructor

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
```
### Propósito:

Maneja una lista de elementos genéricos, permitiendo agregar, obtener y eliminar elementos.

### Métodos:

`agregarElemento(T elemento)`: Añade un elemento a la lista.

`obtenerContenido()`: Retorna la lista de elementos.

`eliminarElemento(T elemento)`: Elimina un elemento específico de la lista.

## `CajaStringEntity`

La clase `CajaStringEntity` representa una entidad que se almacenará en la base de datos, usando JPA (Java Persistence API).

```java

@Entity
@Table(name = "caja_string_entity")
public class CajaStringEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contenido")
    private String contenido;

    // Constructores
    public CajaStringEntity() {
    }

    public CajaStringEntity(String contenido) {
        this.contenido = contenido;
    }

    // Getters y Setters
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


```

### Propósito:

Representa una entrada de caja de texto que se guardará en la base de datos.

### Anotaciones:

`@Entity`: Marca la clase como una entidad JPA.

`@Table`: Define el nombre de la tabla en la base de datos.

`@Id` y `@GeneratedValue`: Configuran el campo id como la clave primaria.


## `Par<K, V>`

La clase `Par<K, V>` es un ejemplo de cómo se pueden usar los generics para crear estructuras de datos más complejas, como un par clave-valor.

```java

public class Par<K, V> {

    private K clave;
    private V valor;
    // Variables clave - valor

    // Constructor
    public Par(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    // Getters y Setters
    public K getClave() {
        return clave;
    }

    public void setClave(K clave) {
        this.clave = clave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }
}

```

### Propósito:

Almacena un par de valores relacionados, uno como clave y otro como valor.

### Métodos:

`getClave()`: Retorna la clave.

`setClave(K clave)`: Establece la clave.

`getValor()`: Retorna el valor.

`setValor(V valor)`: Establece el valor.


# Conclusión

Este proyecto sirve como una guía práctica para comprender el uso de generics en Java. A través de ejemplos claros, puedes ver cómo los generics permiten una programación más flexible y reutilizable. Si tienes alguna pregunta o necesitas más ejemplos, no dudes en preguntar.
