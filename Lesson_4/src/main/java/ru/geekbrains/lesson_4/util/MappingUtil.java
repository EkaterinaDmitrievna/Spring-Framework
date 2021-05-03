package ru.geekbrains.lesson_4.util;

import lombok.NoArgsConstructor;
import ru.geekbrains.lesson_4.dto.ProductDto;
import ru.geekbrains.lesson_4.model.Product;

@NoArgsConstructor
public class MappingUtil {

    public static ProductDto productToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getCost());
    }
    public static Product dtoToProduct (ProductDto dto) {
        return new Product(dto.getId(), dto.getTitle(),dto.getCost(), 1 , false);
    }
}
