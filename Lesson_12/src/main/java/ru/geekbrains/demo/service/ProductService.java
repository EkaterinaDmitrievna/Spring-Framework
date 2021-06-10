package ru.geekbrains.demo.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ru.geekbrains.demo.dto.ProductDto;
import ru.geekbrains.demo.model.Product;
import ru.geekbrains.demo.repository.ProductRepository;
import ru.geekbrains.demo.repository.specifiaction.ProductSpecification;


import java.util.*;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public Page<ProductDto> findAll(Map<String, String> params, Integer pageNumber, Integer pageSize) {
       final Specification<Product> specification = ProductSpecification.build(params);
       return productRepository.findAll(specification, PageRequest.of(pageNumber-1,pageSize)).map(ProductDto::new);
    }

     public Product save(ProductDto productDto) {
        Product product= new Product();
        product.setId(productDto.getId());
         product.setTitle(productDto.getTitle());
         product.setPrice(productDto.getPrice());

             return productRepository.save(product);
     }

     public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
     }



    public ProductDto findProductDtoById(Long id) {
        return  productRepository.findById(id).map(ProductDto::new).orElseThrow(()-> new NoSuchElementException(
                String.format("product with id - %s was not found", id)));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }



}
