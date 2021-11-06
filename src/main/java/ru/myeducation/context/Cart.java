package ru.myeducation.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    List<Product> products;

    public void addProductById(Long id){
        products.add(productRepository.getProducts().stream().filter(p-> p.getId()==id).findFirst().orElseThrow(()->new RuntimeException("Нет такого продукта")));
    }

    public void removeProductById(Long id){
        products.remove(productRepository.getProducts().stream().filter(p-> p.getId()==id).findFirst().orElseThrow(()->new RuntimeException("Нет такого продукта")));
    }

}
