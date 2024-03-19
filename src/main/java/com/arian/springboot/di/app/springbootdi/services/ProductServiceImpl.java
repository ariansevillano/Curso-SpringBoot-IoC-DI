package com.arian.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.arian.springboot.di.app.springbootdi.models.Product;
import com.arian.springboot.di.app.springbootdi.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    //private ProductRepositoryImpl repository = new ProductRepositoryImpl();
//    @Autowired inyección solo como atributo
//    private ProductRepository repository;
    
    private ProductRepository repository;

    public ProductServiceImpl(@Qualifier("productRepositoryImpl") ProductRepository repository) {
        this.repository = repository;
    }
    

//    @Autowired  también se puede inyectar con setter 
//    
//    public void setRepository(ProductRepository repository) {
//        this.repository = repository;
//    }
    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            //p.setPrice(priceTax.longValue());
            //Product newProd = new Product(p.getId(),p.getName(),priceTax.longValue()); //aplicando el principio de inmutabilidad
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
