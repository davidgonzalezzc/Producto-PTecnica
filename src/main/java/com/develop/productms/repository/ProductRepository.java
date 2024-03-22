package com.develop.productms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.productms.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
