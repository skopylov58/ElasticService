package com.example.springelasticproject.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "product")
public class Product {

    @Id
    @JacksonXmlProperty(isAttribute = true)
    private long id;

    @Field(type = FieldType.Boolean)
    private boolean available;

    @Field(type = FieldType.Text)
    private String url;

    @Field(type = FieldType.Long)
    @JacksonXmlProperty(localName = "category_id")
    private long categoryId;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Double)
    private double price;

    @Field(type = FieldType.Text)
    private String picture;

    @Field(type = FieldType.Integer)
    private int weight;


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", available=" + available +
                ", url='" + url + '\'' +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", weight=" + weight +
                '}';
    }
}
