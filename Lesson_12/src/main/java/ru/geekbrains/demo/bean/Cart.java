package ru.geekbrains.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import ru.geekbrains.demo.dto.CartDto;
import ru.geekbrains.demo.dto.OrderDto;
import ru.geekbrains.demo.dto.ProductDto;
import ru.geekbrains.demo.model.Order;
import ru.geekbrains.demo.model.Product;
import ru.geekbrains.demo.service.ProductService;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Component
@SessionScope
@Data
@RequiredArgsConstructor
public class Cart {
    private List<OrderDto> items;
    private final ProductService productService;
    private Integer totalPrice;

    @PostConstruct
    public void init() {
        this.items = new ArrayList<>();
        this.totalPrice=calculateTotalPrice();
    }

    public CartDto getCart(){
        return new CartDto(items,totalPrice);
    }
    public void addToCart(Long id){
        final ProductDto product =productService.findProductDtoById(id);
        final OrderDto orderDto= items.stream()
                .filter(it-> it.getProductId().equals(product.getId()))
                .findFirst()
                .orElse(new OrderDto(product.getId(),product.getTitle(),product.getPrice(),0));
          if (!items.contains(orderDto)){
              items.add(orderDto);
           }
          orderDto.setQuantity(orderDto.getQuantity()+1);
          totalPrice=calculateTotalPrice();
        }


    public void deleteFromCart(Long id) {
        final Optional<OrderDto> orderItem= items.stream()
                .filter(it-> it.getProductId().equals(id))
                .findFirst();
        if (orderItem.isPresent()){
           final OrderDto orderItemDto =orderItem.get();
           if(orderItemDto.getQuantity()==0) {
               return;
           }
           orderItemDto.setQuantity(orderItemDto.getQuantity()-1);
            totalPrice=calculateTotalPrice();
        }

    }
    public void clear(){
        items.clear();
        totalPrice= calculateTotalPrice();
    }

    public Integer calculateTotalPrice(){
        return items.stream()
                .map(it-> it.getPrice()* it.getQuantity())
                .reduce(0, Integer::sum);
    }

}
