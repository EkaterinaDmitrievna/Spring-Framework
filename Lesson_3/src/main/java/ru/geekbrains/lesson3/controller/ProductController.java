package ru.geekbrains.lesson3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.lesson3.dto.Product;
import ru.geekbrains.lesson3.service.ProductService;
@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public String addProduct(@ModelAttribute Product product) {
        productService.add(product);
        return "product";
    }

}
