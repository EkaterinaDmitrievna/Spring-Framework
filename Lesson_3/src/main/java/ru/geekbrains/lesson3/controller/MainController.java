package ru.geekbrains.lesson3.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.lesson3.dto.Product;
import ru.geekbrains.lesson3.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
@Log4j2
public class MainController {

       private final ProductService productService;

        @GetMapping
        @ModelAttribute("products")
        public List<Product> showHtml() {
            return productService.findAll();
        }





    }


