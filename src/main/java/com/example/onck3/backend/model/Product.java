package com.example.onck3.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String name_product;
    private double price;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeProduct typeProduct;

    public Product(String name_product, double price) {
        this.name_product = name_product;
        this.price = price;
    }

    public Product() {
    }

    public Product(String name_product, double price, TypeProduct typeProduct) {
        this.name_product = name_product;
        this.price = price;
        this.typeProduct = typeProduct;
    }

    public Product(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name_product + '\'' +
                ", price=" + price +
                '}';
    }
}
