package com.develop.productms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.productms.entity.Product;
import com.develop.productms.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productoRepository;

    @Override
    public List<Product> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Product> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Product guardarProducto(Product producto) {
        return productoRepository.save(producto);
    }

    @Override
    public boolean eliminarProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

  
}
