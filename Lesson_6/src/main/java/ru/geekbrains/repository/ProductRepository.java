package ru.geekbrains.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.geekbrains.model.Product;
import ru.geekbrains.util.HibernateUtil;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final SessionFactory sessionFactory;


    public Long save(Product product) {
        System.out.println("Action: save");
       return (long) HibernateUtil.doInTransaction(sessionFactory, session -> session.save(product));

    }

    public Product findById(Long id) {
        System.out.println("Action: find by ID");
        return HibernateUtil.doInTransaction(sessionFactory,session -> session.get(Product.class, id));

    }

    public List<Product> findAll() {
        System.out.println("Action: Find All");
        return HibernateUtil.doInTransaction(sessionFactory, session -> session.createQuery("SELECT p FROM Product p", Product.class)
              .getResultList());

    }


}
