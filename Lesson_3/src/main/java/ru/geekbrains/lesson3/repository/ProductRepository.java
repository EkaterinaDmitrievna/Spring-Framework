package ru.geekbrains.lesson3.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson3.dto.Product;

import java.util.*;

@Repository
public class ProductRepository {
    private final static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(UUID.randomUUID(), "milk", 50));
    }

    public void add(Product product) {
        productList.add(product);
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(productList);
    }

    public Product getById(Integer id){
        if (productList.size() != 0) {
            for (Product p : productList) {
                if (id.equals(p.getId())) {
                    return p;
                }
            }
        }
        throw new NoSuchElementException("There is no such id");
    }
}
