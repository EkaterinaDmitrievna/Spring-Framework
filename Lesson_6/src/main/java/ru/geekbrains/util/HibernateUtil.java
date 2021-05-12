package ru.geekbrains.util;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class HibernateUtil {

    public static <T> T doInTransaction(SessionFactory factory, HibernateAction<T> action) {
        try (Session session = factory.getCurrentSession()) {
            try {
               session.beginTransaction();
               final T result = action.perfom(session);
               session.getTransaction().commit();
               return result;

            } catch (Exception exception) {
               session.getTransaction().rollback();
               throw exception;
            }
        }
    }
}
