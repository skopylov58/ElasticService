package com.example.springelasticproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootTest
@EnableElasticsearchRepositories(basePackages = "*")
class SpringElasticProjectApplicationTests {

}
