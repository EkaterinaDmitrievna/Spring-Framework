package ru.geekbrains.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1,"milk", 100));
        products.add(new Product(2,"bread", 40));
        products.add(new Product(3,"butter", 30));
        products.add(new Product(4,"coffee", 150));
        products.add(new Product(5,"ham", 200));

    }

    public Product getById(int id) {
        if(products.size()!=0) {
        for (Product p: products) {
            if (id== p.getId()){
                return p;
            }
        }
    } throw new NoSuchElementException("There is no such id");
}
    }

