package com.example.onck3.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name_type;
    @OneToMany(mappedBy = "typeProduct")
    private List<Product> products;

    public TypeProduct(String name_type) {
        this.name_type = name_type;
    }

    public TypeProduct() {
    }

    @Override
    public String toString() {
        return "TypeProduct{" +
                "id=" + id +
                ", type_name='" + name_type + '\'' +
                '}';
    }
}
