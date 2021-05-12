package ru.geekbrains.util;

import org.hibernate.Session;

@FunctionalInterface
public interface HibernateAction<T> {
    T perfom(Session session);

}
