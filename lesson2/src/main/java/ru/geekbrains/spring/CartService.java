package ru.geekbrains.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class CartService {
    private final Scanner scanner = new Scanner(System.in);
    @Autowired
    private Cart cart;

    public void doCartService () {
        while(true) {
            System.out.println("Print add or delete,show or exit");
            try {
            String cmd = scanner.nextLine();
            int id;
            switch (cmd) {
                case "add":
                    System.out.println("You want to add items, enter index");
                    id = scanner.nextInt();
                    cart.addToCart(id);
                    System.out.println(cart.showCart());
                    break;
                case "delete":
                    System.out.println("You want to delete items, enter index");
                    id = scanner.nextInt();
                    cart.deleteFromCart(id);
                    System.out.println(cart.showCart());
                    break;
                case "show":
                    System.out.println("Your cart contains: " + cart.showCart());
                    break;

                case "exit":
                    System.out.println("You want to exit, bye" );
                    scanner.close();
                    return;
                   }

            } catch (Exception e){
                e.printStackTrace();
            }

        }

    }




}
