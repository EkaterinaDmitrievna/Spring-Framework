package ru.geekbrains.demo.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.demo.dto.ProductDto;
import ru.geekbrains.demo.model.Product;
import ru.geekbrains.demo.service.CategoryService;
import ru.geekbrains.demo.service.ProductService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductDto> findAll(@RequestParam Map<String, String> params,
                                    @RequestParam(name ="page",defaultValue = "1") Integer pageNumber,
                                    @RequestParam(name ="page-size",defaultValue = "5") Integer pageSize
                                   ) {
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        return productService.findAll(params,pageNumber,pageSize);
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return productService.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @PutMapping
    public Product update (@RequestBody ProductDto productDto) {
                return  productService.save(productDto);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
