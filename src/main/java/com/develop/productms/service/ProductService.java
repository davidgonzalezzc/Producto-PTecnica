package com.develop.productms.service;

import java.util.List;
import java.util.Optional;

import com.develop.productms.entity.Product;

public interface ProductService {
    List<Product> obtenerTodosLosProductos();
    Optional<Product> obtenerProductoPorId(Long id);
    Product guardarProducto(Product producto);
    boolean eliminarProducto(Long id);
}