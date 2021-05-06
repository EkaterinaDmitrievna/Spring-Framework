package ru.geekbrains.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    private String title;

    private int price;

    public Product() {
    }

    public Product(Long id, String title, int price) {
        this.id =id;
        this.title = title;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return String.format("[id: %s, title: %s, price: %s]", id, title, price);
    }

}
