package ru.myeducation.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    @Autowired
    private ProductService productService;

    public void createOrderFromProduct(Long productId){
        System.out.println("Order created:");
        System.out.println(productService.getTitleById(productId));
    }
}
