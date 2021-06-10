package ru.geekbrains.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ru.geekbrains.demo.model.Product;



public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {



}
