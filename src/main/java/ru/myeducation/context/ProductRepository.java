package ru.myeducation.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread"),
                new Product(2L, "Milk"),
                new Product(3L, "Apples"),
                new Product(4L, "Cheese"),
                new Product(5L, "Fish")
        ));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Optional<Product> findById(Long id){
        return products.stream().filter(n -> n.getId() == id).findFirst();
    }
}
