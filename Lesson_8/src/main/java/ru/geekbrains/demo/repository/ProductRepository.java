package ru.geekbrains.demo.repository;

import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.demo.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
 Page<Product> findAll(Pageable pageable);
}
