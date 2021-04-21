package ru.geekbrains.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope (scopeName ="prototype")
public class Cart {
    @Autowired
    private ProductRepository productRepository;
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList= new ArrayList<>();
    }

    public void addToCart(int id) {
        productList.add(productRepository.getById(id));
    }
    public void deleteFromCart(int id) {
        for(Product product: productList) {
            if (id ==product.getId()) {
                productList.remove(product);
                return;
            }
        }

    }
    public List<Product> showCart (){
        return productList;
    }


}
