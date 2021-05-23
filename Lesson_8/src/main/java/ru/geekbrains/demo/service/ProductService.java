package ru.geekbrains.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.geekbrains.demo.model.Product;
import ru.geekbrains.demo.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
       return productRepository.findAll();
    }
     public Product save(Product product) {
        return (Product) productRepository.save(product);
    }
    public Optional<Product> findById(Long id) {
        return  productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> getProductPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


}
