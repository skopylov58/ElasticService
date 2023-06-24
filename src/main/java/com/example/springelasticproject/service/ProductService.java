package com.example.springelasticproject.service;


import com.example.springelasticproject.model.Product;
import com.example.springelasticproject.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> searchProduct (String query, int categoryId) {
        return productRepository.searchProducts(query, categoryId);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

}
