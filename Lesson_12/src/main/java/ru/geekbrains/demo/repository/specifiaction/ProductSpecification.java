package ru.geekbrains.demo.repository.specifiaction;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import ru.geekbrains.demo.dto.ProductDto;
import ru.geekbrains.demo.model.Product;


import java.util.Map;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductSpecification {
    public static Specification<Product> nameEquals(String title) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"),title);
    }
    public static Specification<Product> priceEquals(Integer price) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("price"),price);
    }
//    public static Specification<ProductDto> categoryEquals(String category) {
//        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("category"),category);
//    }
//    public static Specification<ProductDto> buildCategory(Map<String,String> paramsDto) {
//        return paramsDto.entrySet().stream()
//                .filter(it-> StringUtils.hasText(it.getValue()))
//                .map(it-> {
//                    if ("category".equals(it.getKey())) {
//                        return ProductSpecification.categoryEquals(it.getValue());
//                    } return null;
//                })
//                .filter(Objects::nonNull)
//                .reduce(Specification::and)
//                .orElse(null);
//                }

    public static Specification<Product> build(Map<String, String> params){
        return params.entrySet().stream()
                .filter(it-> StringUtils.hasText(it.getValue()))
                .map(it->{
                    if ("title".equals(it.getKey())) {
                        return ProductSpecification.nameEquals(it.getValue());
                    }
                    if ("price".equals(it.getKey())) {
                        return ProductSpecification.priceEquals(Integer.parseInt(it.getValue()));
                    }

                    return null;
                })
                .filter(Objects::nonNull)
                .reduce(Specification::and)
                .orElse(null);
    }
}
