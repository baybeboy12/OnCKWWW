package com.example.onck3.backend.services;

import com.example.onck3.backend.model.Product;
import com.example.onck3.backend.model.TypeProduct;
import com.example.onck3.backend.repositories.TypeProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeProductService {
    @Autowired
    private TypeProductRepositories typeProductRepositories;
    public List<TypeProduct> findAllTypeProduct(){
        return typeProductRepositories.findAll();
    }
    public TypeProduct findTypeProductById(long id){
        Optional<TypeProduct> op = typeProductRepositories.findById(id);
        return op.get();
    }

    public void addTypeProduct(TypeProduct typeProduct){
        typeProductRepositories.save(typeProduct);
    }
    public void updateTypeProduct(TypeProduct typeProduct){
        typeProductRepositories.save(typeProduct);
    }
    public void deleteTypeProduct(long id){
        typeProductRepositories.deleteById(id);
    }
}
