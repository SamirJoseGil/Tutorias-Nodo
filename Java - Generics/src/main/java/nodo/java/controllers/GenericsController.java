package nodo.java.controllers;

import nodo.java.models.*;
import nodo.java.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generics")
public class GenericsController {

    @Autowired
    private CajaStringRepository cajaStringRepository;

    // ================================
    // Ejemplos de Caja
    // ================================

    // Ejemplo de Caja para String
    @GetMapping("/string")
    public Caja<String> obtenerCajaDeString() {
        return new Caja<>("Hola desde la Caja de String");
    }

    // Ejemplo de Caja para Integer
    @GetMapping("/integer")
    public Caja<Integer> obtenerCajaDeInteger() {
        return new Caja<>(123);
    }

    // Ejemplo dinámico, que recibe el contenido vía un parámetro en la URL
    @GetMapping("/dynamic")
    public <T> Caja<T> obtenerCajaDinamica(@RequestParam T contenido) {
        return new Caja<>(contenido);
    }

    // ================================
    // Operaciones con Lista de Strings
    // ================================

    // Endpoint para crear una nueva caja con un String
    @PostMapping("/list/string")
    public ResponseEntity<CajaStringEntity> createStringCaja(@RequestBody String contenido) {
        CajaStringEntity newCaja = new CajaStringEntity(contenido);
        cajaStringRepository.save(newCaja);
        return ResponseEntity.ok(newCaja);
    }

    // Endpoint para obtener todas las cajas con String
    @GetMapping("/list/string")
    public CajaList<CajaStringEntity> getAllStringCajas() {
        List<CajaStringEntity> cajas = cajaStringRepository.findAll();
        CajaList<CajaStringEntity> cajaList = new CajaList<>();
        
        for (CajaStringEntity caja : cajas) {
            cajaList.agregarElemento(caja);
        }
        
        return cajaList; // Retorna la lista de cajas en una CajaList
    }

    // Endpoint para eliminar una caja por ID
    @DeleteMapping("/string/{id}")
    public ResponseEntity<Void> deleteCajaDeString(@PathVariable Long id) {
        if (cajaStringRepository.existsById(id)) {
            cajaStringRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    // ================================
    // Ejemplos de Pareja de Datos
    // ================================

    // Ejemplo de Par clave-valor con String y Integer
    @GetMapping("/pair")
    public Par<String, Integer> obtenerPar() {
        return new Par<>("hola mundio",1234);
    }

    // Ejemplo de Par con tipos genéricos personalizados
    @GetMapping("/pair/dynamic")
    public <K, V> Par<K, V> obtenerParDinamico(@RequestParam K clave, @RequestParam V valor) {
        return new Par<>(clave, valor);
    }
}
