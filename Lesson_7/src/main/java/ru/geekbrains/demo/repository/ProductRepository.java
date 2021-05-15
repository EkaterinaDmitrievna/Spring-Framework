package ru.geekbrains.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.demo.model.Product;

import java.util.List;


public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findAllByPriceIsGreaterThanEqual(int minPrice);
    List<Product> findAllByPriceIsBefore(int maxPrice);
    List<Product> findAllByPriceBetween(Integer minPrice, Integer maxPrice);


}
