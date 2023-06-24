package com.example.springelasticproject.repository;

import com.example.springelasticproject.model.Product;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, Long> {
    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}], \"filter\": [{\"term\": {\"categoryId\": \"?1\"}}]}}")
    List<Product> searchProducts(String query, int categoryId);
}
