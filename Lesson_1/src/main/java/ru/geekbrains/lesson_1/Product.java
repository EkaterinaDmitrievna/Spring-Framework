package ru.geekbrains.lesson_1;

public class Product {
    private String title;
    private int cost;
    private int id;
    public Product(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", cost=" + cost +
                ", id=" + id +
                '}';
    }
}
