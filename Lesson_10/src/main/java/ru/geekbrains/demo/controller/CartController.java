package ru.geekbrains.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.demo.bean.Cart;
import ru.geekbrains.demo.dto.CartDto;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final Cart cart;

    @GetMapping
    public CartDto getCart() {
        return cart.getCart();
    }

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id){
        cart.addToCart(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteFromCart(@PathVariable Long id){
        cart.deleteFromCart(id);
    }
    @GetMapping("/clear")
    public void clearCart() {
        cart.clear();
    }

}
