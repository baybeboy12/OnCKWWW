package com.example.onck3.frontend.controller;

import com.example.onck3.backend.model.TypeProduct;
import com.example.onck3.backend.services.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TypeProductController {
    @Autowired
    private TypeProductService typeProductService;
    @GetMapping("/typeProducts")
    public String getAllTypeProducts(Model model){
        List<TypeProduct> typeProducts = typeProductService.findAllTypeProduct();
        model.addAttribute("typeProducts",typeProducts);
        return "typeProduct/listTypeProduct";
    }
}
