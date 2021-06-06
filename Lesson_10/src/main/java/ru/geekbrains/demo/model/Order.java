package ru.geekbrains.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    private int quantity;
    private int price;
    @Column(name = "total_price")
    private int totalPrice;

    public Order (Product product) {
        this.product =product;
        this.quantity=1;
        this.price=product.getPrice();
        this.totalPrice=this.price;

    }



}
