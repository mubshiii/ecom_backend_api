package com.example.demo.controller;

import com.example.demo.model.Products;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")//addproduct
    public Products addProduct(@RequestBody Products product){
        return productService.addProduct(product);

    }

    @GetMapping//getallproducts
    public List<Products> getAllProducts(){
        return productService.getAllProducts();

    }

    @GetMapping("/{product_id}") //getproductbyid
    public Products getProduct(@PathVariable Integer product_id){
        return productService.getProduct(product_id);
    }

    @PutMapping("/{product_id}")//update put
        public Products updateProductById(@PathVariable Integer product_id,@RequestBody Products product){
        return productService.updateProductById(product_id,product);

    }
    }


