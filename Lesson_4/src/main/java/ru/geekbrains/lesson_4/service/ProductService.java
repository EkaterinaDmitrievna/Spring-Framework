package ru.geekbrains.lesson_4.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.geekbrains.lesson_4.dto.ProductDto;
import ru.geekbrains.lesson_4.model.Product;
import ru.geekbrains.lesson_4.repository.ProductRepository;
import ru.geekbrains.lesson_4.util.MappingUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Long save(ProductDto productDto) {
        if(productDto.getId()==null) {
            return productRepository.create(MappingUtil.dtoToProduct(productDto)).getId();
        } else {
            return productRepository.update(MappingUtil.dtoToProduct(productDto)).getId();
        }
    }
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(MappingUtil::productToDto)
                .collect(Collectors.toList());
    }
    public List<ProductDto> findAll(Integer minCost, Integer maxCost) {
        List<ProductDto> out = findAll();
        if (minCost!= null) {
            out = out.stream().filter(s->s.getCost()>= minCost).collect(Collectors.toList());
        }
        if (maxCost!= null) {
            out = out.stream().filter(s->s.getCost()<= maxCost).collect(Collectors.toList());
        }
        return out;
    }
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getById(Long id) {
       return productRepository.getById(id);
    }


}
