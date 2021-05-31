package ru.geekbrains.demo.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ru.geekbrains.demo.dto.CategoryDto;
import ru.geekbrains.demo.dto.ProductDto;
import ru.geekbrains.demo.model.Category;
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

             return productRepository.save(new Product(productDto.getId(),productDto.getTitle(),productDto.getPrice(),productDto.getCategory()));
     }



    public ProductDto findById(Long id) {
        return  productRepository.findById(id).map(ProductDto::new).orElseThrow(()-> new NoSuchElementException(
                String.format("product with id - %s was not found", id)));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }



}
