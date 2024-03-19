/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arian.springboot.di.app.springbootdi.repositories;

import com.arian.springboot.di.app.springbootdi.models.Product;

import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ariax
 */
@Primary //le dice a spring que utilice este bean, para elegir que instancia del repository usará
@Repository
public class ProductRepositoryFoo implements ProductRepository {


    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor Asus", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor Asus", 600L);
    }
    
    
    
}
