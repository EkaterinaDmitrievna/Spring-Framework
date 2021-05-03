package ru.geekbrains.lesson_4.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson_4.model.Product;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private final static List<Product> productList = new CopyOnWriteArrayList<>();
    private final AtomicLong generator = new AtomicLong();


    @PostConstruct
    public void init(){
        productList.addAll(List.of(
                new Product(generator.incrementAndGet(), "milk", 50, 1, false),
                new Product(generator.incrementAndGet(), "bread", 30, 1, false)
        ));
    }

    public Product create(Product product) {
        product.setId(generator.incrementAndGet());
        productList.add(product);
        return product;
    }
    public Product update(Product product) {
        if (product.getId()== null) {
            return null;
            }
        Product existingProduct = productList.stream()
                .filter(it-> it.getId().equals((product.getId())))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        product.setId(existingProduct.getId());
        product.setVersion(existingProduct.getVersion()+1);
        productList.add(product);
        return product;

    }



    public List<Product> findAll() {

        return productList.stream()
                .filter(it-> !it.getIsDeleted())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Product> getById(Long id){

        List<Product>  toGet = productList.stream()
                .filter((it-> it.getId().equals(id)))
                .findFirst()
                .stream().collect(Collectors.toList());
       return toGet;
    }

    public int deleteById(long id) {
        List<Product> toDelete = productList.stream()
                .filter(it -> it.getId().equals(id))
                .collect(Collectors.toList());
        toDelete.forEach(it -> it.setIsDeleted(true));
        return toDelete.size();
    }
}
