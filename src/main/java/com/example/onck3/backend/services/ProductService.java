package com.example.onck3.backend.services;

import com.example.onck3.backend.model.Product;
import com.example.onck3.backend.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepositories productRepositories;
    public List<Product> findAll(){
      return   productRepositories.findAll();
    }
    public Product findProductById(long id){
        Optional<Product> op = productRepositories.findById(id);
        return op.get();
    }
    public List<Product> findProductByType_Id(long id){
        return productRepositories.findProductsByTypeProduct(id);
    }
    public void addProduct(Product product){
        productRepositories.save(product);
    }
    public void updateProduct(Product product){
        productRepositories.save(product);
    }
    public void deleteProduct(long id){
        productRepositories.deleteById(id);
    }
}
