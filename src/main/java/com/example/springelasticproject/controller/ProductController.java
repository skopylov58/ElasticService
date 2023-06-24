package com.example.springelasticproject.controller;

import com.example.springelasticproject.model.Product;
import com.example.springelasticproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public Iterable<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/products")
    public List<Product> searchProducts(@RequestParam String query, @RequestParam int categoryId) {
        return productService.searchProduct(query,categoryId);
    }
}
