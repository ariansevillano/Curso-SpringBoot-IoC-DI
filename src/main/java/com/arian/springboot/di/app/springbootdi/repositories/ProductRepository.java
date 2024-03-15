package com.arian.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import com.arian.springboot.di.app.springbootdi.models.Product;

public class ProductRepository {
    
    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Arian", 150L),
            new Product(2L, "Erick", 180L),
            new Product(3L, "Juan", 190L)
        );
    }

    public List<Product> findAll() {
        return data;
    }

    public Product finById (Long id) {
        //return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }





}