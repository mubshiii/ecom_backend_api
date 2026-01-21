package com.example.demo.service;

import com.example.demo.model.Products;
import com.example.demo.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductsRepo productRepo;

    public Products updateOnlyFields(Integer product_id, Products product) {
        Products existing=productRepo.findById(product_id).orElseThrow(()-> new RuntimeException("Product not found"));
        if(product.getName()!=null)
        {
         existing.setName(product.getName());
        }
        if(product.getDescription()!=null)
        {
            existing.setDescription(product.getDescription());
        }
        if(product.getCategory()!=null)
        {
            existing.setCategory(product.getCategory());
        }
        if(product.getPrice()!=null)
        {
            existing.setPrice(product.getPrice());
        }
        if(product.getQuantity()!=null)
        {
            existing.setQuantity(product.getQuantity());
        }
        if(product.getImageUrl()!=null)
        {
            existing.setImageUrl(product.getImageUrl());
        }
        return productRepo.save(existing);
    }

    public Products addProduct(Products product){
       return productRepo.save(product);
    }

    public Products getProduct(Integer product_id) {
        return productRepo.findById(product_id).orElse(null);
    }

    public List<Products> getAllProducts() {
        return productRepo.findAll();
    }

    public Products updateProductById(Integer product_id,Products product){
       Products existing = productRepo.findById(product_id).orElseThrow(() -> new RuntimeException("Product not found"));
       existing.setName(product.getName());
       existing.setCategory(product.getCategory());
       existing.setPrice(product.getPrice());
       existing.setDescription(product.getDescription());
       existing.setQuantity(product.getQuantity());
       existing.setImageUrl(product.getImageUrl());
        return productRepo.save(existing);
    }
}
