package com.example.springelasticproject.repository;

import com.example.springelasticproject.model.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ElasticsearchRepository<Category, Long> {
}
