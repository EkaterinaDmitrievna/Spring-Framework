package ru.geekbrains.repository;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.geekbrains.model.Person;
import ru.geekbrains.model.Product;
import ru.geekbrains.util.HibernateUtil;

import java.util.List;
@Repository
@RequiredArgsConstructor

public class PersonRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void getProducts(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            try {
        session.beginTransaction();
        Person person1 = session.get(Person.class, id);
        System.out.println(person1);
        System.out.println("Products: ");
        String products = null;
        for(Product p: person1.getProductList()) {
            products = p.getTitle();
              System.out.println(products);
        }}catch (Exception e) {
                e.printStackTrace();
            }}

    }


    public Long save(Person person) {
        System.out.println("Action: save");
        return (long) HibernateUtil.doInTransaction(sessionFactory, session -> session.save(person));

    }

    public Person findById(Long id) {
        System.out.println("Action: find by ID");
        return HibernateUtil.doInTransaction(sessionFactory,session -> session.get(Person.class, id));

    }

    public List<Person> findAll() {
        System.out.println("Action: Find All");
        return HibernateUtil.doInTransaction(sessionFactory, session -> session.createQuery("SELECT p FROM Person p", Person.class)
                .getResultList());

    }

}
