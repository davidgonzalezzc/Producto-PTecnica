package com.develop.productms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.productms.entity.Product;
import com.develop.productms.service.ProductService;

@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private ProductService productoService;

    // Obtener todos los productos
    @GetMapping
    public List<Product> obtenerTodosLosProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> obtenerProductoPorId(@PathVariable Long id) {
        Optional<Product> productoOptional = productoService.obtenerProductoPorId(id);
        return productoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<Product> crearNuevoProducto(@RequestBody Product producto) {
        Product nuevoProducto = productoService.guardarProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    // Actualizar un producto existente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Product> actualizarProducto(@PathVariable Long id, @RequestBody Product producto) {
        if (!productoService.obtenerProductoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        producto.setId(id);
        Product productoActualizado = productoService.guardarProducto(producto);
        return ResponseEntity.ok(productoActualizado);
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        boolean eliminado = productoService.eliminarProducto(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}