package ru.geekbrains.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.demo.model.Order;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long productId;
    private String productTitle;
    private int price;
    private int quantity;


    public OrderDto(Order order) {
        this.productId =order.getProduct().getId();
        this.productTitle=order.getProduct().getTitle();
        this.quantity=order.getQuantity();
        this.price=order.getPrice();

    }

}
