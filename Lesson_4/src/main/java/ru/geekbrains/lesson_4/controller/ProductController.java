package ru.geekbrains.lesson_4.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.lesson_4.dto.ProductDto;
import ru.geekbrains.lesson_4.model.Product;
import ru.geekbrains.lesson_4.service.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
@Log4j2
public class ProductController {
        private final ProductService productService;

        @GetMapping
        public String findAll(Model model, @RequestParam(required = false, name = "min_cost") Integer minCost,
                                        @RequestParam(required = false, name = "max_cost") Integer maxCost) {
            model.addAttribute("products", productService.findAll(minCost, maxCost));
            return "product";
        }
        @PostMapping
        public String create(@ModelAttribute ProductDto productDto) {
            productService.save(productDto);
            return "redirect:/product";
        }
    @GetMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/product";
    }

     
    }

