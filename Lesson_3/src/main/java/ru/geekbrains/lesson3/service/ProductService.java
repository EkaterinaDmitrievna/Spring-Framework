package ru.geekbrains.lesson3.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.geekbrains.lesson3.dto.Product;
import ru.geekbrains.lesson3.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductService {
    private final ProductRepository productRepository;

    public void add(Product product){
        log.debug("Adding product");
        if(product.getId()== null) {
            product.setId(UUID.randomUUID());
        }
        productRepository.add(product);


    }
    public List<Product> findAll(){
        log.debug("findAll");
        return productRepository.findAll();
    }

    public  Product getById(int id){
        log.debug("You want to find a product with id: %s" +id);
        if(id == 0) {
            throw new NullPointerException("Id can't be null");

        }return productRepository.getById(id);
    }
}
