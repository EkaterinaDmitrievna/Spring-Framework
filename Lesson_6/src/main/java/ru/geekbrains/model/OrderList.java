//package ru.geekbrains.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import ru.geekbrains.repository.PersonRepository;
//import ru.geekbrains.repository.ProductRepository;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//
//public class OrderList {
//  private PersonRepository personRepository;
//  private ProductRepository productRepository;
//  private final SessionFactory sessionFactory;
//
//    public void getProducts(Long id) {
//        Session session = null;
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Person person1 = session.get(Person.class, id);
//        System.out.println(person1);
//        System.out.println("Products: ");
//        for(Product p: person1.getProductList()) {
//            System.out.println(p.getTitle());
//
//        }
//    }
//
//}
