package ru.geekbrains.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;
import ru.geekbrains.demo.model.Product;
import ru.geekbrains.demo.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @PostMapping
    public Product save(@RequestBody Product product) {
       return  productRepository.save(product);
    }
    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return  productRepository.findById(id);
    }
    @GetMapping("/findAll")
    public List<Product> findAll(){
        return (List<Product>) productRepository.findAll();
    }
    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
    @GetMapping("/search_by_min_price")
    public List<Product> searchByMinPrice(@RequestParam(name = "min_price") Integer minPrice){
        return productRepository.findAllByPriceIsGreaterThanEqual(minPrice);
    }
    @GetMapping("/search_by_max_price")
    public List<Product> searchByMaxPrice(@RequestParam(name = "max_price") Integer maxPrice){
        return productRepository.findAllByPriceIsBefore(maxPrice);
    }
    @GetMapping("/search_between_prices")
    public List<Product> searchBetweenPrices(@RequestParam(name = "min_price") Integer minPrice, @RequestParam(name = "max_price") Integer maxPrice){
        return productRepository.findAllByPriceBetween(minPrice,maxPrice);
    }

}
