package com.arian.springboot.di.app.springbootdi.repositories;

import java.util.List;

import com.arian.springboot.di.app.springbootdi.models.Product;
import org.springframework.beans.factory.annotation.Autowired;


public interface ProductRepository {
    List<Product> findAll();

    Product findById(Long id);
}
