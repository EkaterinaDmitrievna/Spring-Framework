package ru.geekbrains.dao;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.entity.Product;
import java.util.List;


public class ProductDao {
    private static org.hibernate.SessionFactory factory;
    private static Session session;

    public static void init() {
        factory = new Configuration().configure("hibernate.cgf.xml").buildSessionFactory();
    }
    public static void shutdown() {
        factory.close();
        if (session != null) {
            session.close();
        }
    }


    public static void main(String[] args) {

        try {
            init();
            findAll();
//          saveOrUpdate();
//          findById(1L);
//          deleteById(1L);

        } catch (Exception e) { e.printStackTrace();
        } finally { shutdown();
        }
    }

    public static Product saveOrUpdate() {
        System.out.println(" ACTION: Save or Update");
        session = factory.getCurrentSession();
        session.beginTransaction();
        Product productFromBD =new Product(1L, "milk", 50);
        session.saveOrUpdate(productFromBD);
        session.getTransaction().commit();
        return productFromBD;

    }

    public static Product add() {
        System.out.println(" ACTION: Add to BD");
        session = factory.getCurrentSession();
        session.beginTransaction();
        Product productToAdd = new Product(5L, "milk", 50);
        session.save(productToAdd);
        session.getTransaction().commit();
        return productToAdd;

    }

    public static Product findById(Long id) {
        System.out.println("Action: find by ID");
        session = factory.getCurrentSession();
        session.beginTransaction();

        Product productFromDb2 = session.createQuery("SELECT p FROM Product p where p.id = :id ", Product.class)
                .setParameter("id", id)
                .getSingleResult();
        System.out.println(productFromDb2);
        session.getTransaction().commit();
        return productFromDb2;
    }

    public static List<Product> findAll() {
        System.out.println("Action: Find All");
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
        session.getTransaction().commit();
        return products;
    }

    public static void deleteById(Long id) {
        System.out.println("Action: delete by ID");
        session = factory.getCurrentSession();
        session.beginTransaction();
        Product productToDelete = session.get(Product.class, id);
        session.delete(productToDelete);
        System.out.println(productToDelete);
        session.getTransaction().commit();
    }

    }


