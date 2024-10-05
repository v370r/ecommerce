package com.vijay.ecommerce.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vijay.ecommerce.dto.ProductListDTO;
import com.vijay.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT new com.example.demo.dto.ProductListDTO(p.id, p.name, p.description, p.price, p.quantity, p.image) FROM Product p")
    Page<ProductListDTO> findAllWithoutComments(Pageable pageable);
}