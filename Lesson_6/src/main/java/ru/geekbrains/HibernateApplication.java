package ru.geekbrains;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.geekbrains.model.Person;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.PersonRepository;
import ru.geekbrains.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
        PersonRepository repository = new PersonRepository();
        repository.getProducts(3L);

    }
//    @Bean
//    public CommandLineRunner runner(PersonRepository personRepository) {
//        return args -> {
//            String products =  personRepository.getProducts(3L);
//            System.out.println(products);
//
//        };
//    }

}
