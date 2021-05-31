package ru.geekbrains.demo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.demo.model.Category;
import ru.geekbrains.demo.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductService productService;

    public List<Category> findAll() {

        return categoryRepository.findAll();
    }

}
