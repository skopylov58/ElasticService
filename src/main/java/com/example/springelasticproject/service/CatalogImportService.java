package com.example.springelasticproject.service;

import com.example.springelasticproject.model.Category;
import com.example.springelasticproject.model.DcCatalog;
import com.example.springelasticproject.model.Product;
import com.example.springelasticproject.repository.CategoryRepository;
import com.example.springelasticproject.repository.ProductRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@Service
public class CatalogImportService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CatalogImportService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    //FIXME Изменить сигнатуру метода на 
    //public void importCatalogFromUrl(String url) throws IOException 
    @Transactional
    public void importCatalogFromUrl(String url) throws IOException {

        String xml = getContent(url);
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            DcCatalog dcCatalog = objectMapper.readValue(xml, DcCatalog.class);
            List<Category> categories = dcCatalog.getDeliveryService().getCategories().getCategory();
            List<Product> products = dcCatalog.getDeliveryService().getProducts().getProduct();

            System.out.println("Categories:");
            for (Category category : categories) {
                System.out.println(category);
            }

            System.out.println("\nProducts:");
            for (Product product : products) {
                System.out.println(product);
            }

//            categoryRepository.saveAll(categories);
            productRepository.saveAll(products);

        //FIXME Убрать catch
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private String getContent(String url) throws IOException{
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return responseEntity.getBody();
    }

}
