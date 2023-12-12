package com.example.onck3.frontend.controller;

import com.example.onck3.backend.model.Product;
import com.example.onck3.backend.model.TypeProduct;
import com.example.onck3.backend.services.ProductService;
import com.example.onck3.backend.services.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private TypeProductService typeProductService;
    @GetMapping("/products/{id}")
    public String getProductsByTypeProduct(@PathVariable("id") long id, Model model){
        List<Product> products = productService.findProductByType_Id(id);
        model.addAttribute("products",products);
        return "product/listProduct";
    }
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id){
        Product product = productService.findProductById(id);
        productService.deleteProduct(id);
        return "redirect:/admin/products/"+product.getTypeProduct().getId();
    }
    @GetMapping("/products/add-form")
    public String showAddForm(Model model){
        Product product = new Product();
        List<TypeProduct> typeProducts = typeProductService.findAllTypeProduct();
        model.addAttribute("addProduct",product);
        model.addAttribute("typeProducts",typeProducts);
        return "/product/addProduct";
    }
    @PostMapping("/products/addProduct")
    public String addProduct(@ModelAttribute("addProduct") Product product){
        productService.addProduct(product);
        return  "redirect:/admin/products/"+product.getTypeProduct().getId();

    }
    @GetMapping("/products/update/{id}")
    public String showUpdateForm(@PathVariable("id") long id,Model model){
        Product product = productService.findProductById(id);
        model.addAttribute("updateProduct",product);
        return "product/updateProduct";
    }
    @PostMapping("/products/update")
    public String updateProduct(@ModelAttribute("updateProduct") Product product){
        productService.updateProduct(product);
        return  "redirect:/admin/products/"+product.getTypeProduct().getId();
    }
}
