package ru.geekbrains.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;
import ru.geekbrains.demo.model.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
