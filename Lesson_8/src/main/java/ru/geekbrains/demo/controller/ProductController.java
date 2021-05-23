package ru.geekbrains.demo.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.demo.model.Product;
import ru.geekbrains.demo.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }


    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }


    @GetMapping("delete/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
