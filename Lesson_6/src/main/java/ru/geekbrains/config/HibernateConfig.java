package ru.geekbrains.config;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import ru.geekbrains.model.Person;
import ru.geekbrains.model.Product;


@org.springframework.context.annotation.Configuration
public class HibernateConfig {

    @Bean
    public org.hibernate.cfg.Configuration config() {
        return new Configuration()
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Person.class);

    }

    @Bean
    public SessionFactory sessionFactory() {
        return config().buildSessionFactory();
    }


}
