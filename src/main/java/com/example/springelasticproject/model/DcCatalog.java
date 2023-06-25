package com.example.springelasticproject.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DcCatalog {
    @JacksonXmlProperty(localName = "delivery_service")
    private DeliveryService deliveryService;
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeliveryService {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "categories")
        private Categories categories;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "products")
        private Products products;


        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Categories {
            @JacksonXmlElementWrapper(useWrapping = false)
            @JacksonXmlProperty(localName = "category")
            private List<Category> category;
        }

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Products {
            @JacksonXmlElementWrapper(useWrapping = false)
            @JacksonXmlProperty(localName = "product")
            private List<Product> product;
        }
    }
}
