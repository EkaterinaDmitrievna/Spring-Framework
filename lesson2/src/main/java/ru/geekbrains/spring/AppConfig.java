package ru.geekbrains.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("ru.geekbrains.spring")
public class AppConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        System.out.println("You can buy the following: ");
        System.out.println(productRepository.getProducts());
        CartService cartService = context.getBean(CartService.class);
        cartService.doCartService();
        context.close();
    }

}
