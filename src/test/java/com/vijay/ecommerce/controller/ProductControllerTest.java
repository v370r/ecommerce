package com.vijay.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vijay.ecommerce.model.Product;
import com.vijay.ecommerce.repositories.ProductRepository;
import java.util.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        productRepository.deleteAll();
    }

    @Test
    public void testAddProduct() {
        Product product = new Product();
        product.setName("Test Product");

        ResponseEntity<Product> response = restTemplate.postForEntity("/api/products", product, Product.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Test Product", response.getBody().getName());
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setName("Test Product");
        product = productRepository.save(product);

        ResponseEntity<Product> response = restTemplate.getForEntity("/api/products/" + product.getId(), Product.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Test Product", response.getBody().getName());
    }

    @Test
    public void testGetAllProducts() {
        Product product1 = new Product();
        product1.setName("Test Product 1");

        Product product2 = new Product();
        product2.setName("Test Product 2");

        productRepository.saveAll(Arrays.asList(product1, product2));

        ResponseEntity<Product[]> response = restTemplate.getForEntity("/api/products", Product[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<Product> products = Arrays.asList(response.getBody());
        assertEquals(2, products.size());
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setName("Test Product");
        product = productRepository.save(product);

        product.setName("Updated Product");
        restTemplate.put("/api/products/" + product.getId(), product);

        ResponseEntity<Product> response = restTemplate.getForEntity("/api/products/" + product.getId(), Product.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated Product", response.getBody().getName());
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product();
        product.setName("Test Product");
        product = productRepository.save(product);

        restTemplate.delete("/api/products/" + product.getId());

        ResponseEntity<Product> response = restTemplate.getForEntity("/api/products/" + product.getId(), Product.class);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
