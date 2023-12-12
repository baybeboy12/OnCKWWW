package com.example.onck3;

import com.example.onck3.backend.model.Product;
import com.example.onck3.backend.model.TypeProduct;
import com.example.onck3.backend.repositories.TypeProductRepositories;
import com.example.onck3.backend.services.ProductService;
import com.example.onck3.backend.services.TypeProductService;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OnCk3Application {
    @Autowired
    private TypeProductService typeProductService;
    @Autowired
    private ProductService productService;
    @Autowired
    private TypeProductRepositories typeProductRepositories;
    public static void main(String[] args) {
        SpringApplication.run(OnCk3Application.class, args);
    }

//    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
//            Faker faker = new Faker();
//            for (int i = 0; i < 5; i++) {
//                TypeProduct typeProduct = new TypeProduct(faker.commerce().productName());
//                typeProductService.addTypeProduct(typeProduct);
//                for (int j = 0; j < 4; j++) {
//                    Product product = new Product(faker.commerce().productName(),Double.parseDouble(faker.commerce().price()),typeProduct);
//                    productService.addProduct(product);
//                }
//            }
            List<Product> products = productService.findProductByType_Id(1l);
            for (Product product:products
                 ) {
                System.err.println(product);
            }

        };
    }
}
