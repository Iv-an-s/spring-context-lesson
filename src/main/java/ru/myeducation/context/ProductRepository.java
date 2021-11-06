package ru.myeducation.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;


    @PostConstruct
    public void init(){
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
    
    public Product findById (Long id){
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getId() == id){
//                return products.get(i);
//            }
//        }
//        return null;
        return products.stream().filter(n -> n.getId()==id).findFirst().orElseThrow(()-> new RuntimeException("..."));
    }
}
