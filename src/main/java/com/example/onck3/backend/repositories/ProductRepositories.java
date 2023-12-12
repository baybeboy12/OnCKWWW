package com.example.onck3.backend.repositories;

import com.example.onck3.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepositories extends JpaRepository<Product,Long> {
    @Query("select p from Product p where p.typeProduct.id =:id")
    public List<Product> findProductsByTypeProduct(long id);
}
