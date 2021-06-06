package ru.geekbrains.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDto {
    private List<OrderDto> items;
    private Integer totalPrice;


}
