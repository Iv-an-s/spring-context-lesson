package ru.myeducation.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public String getTitleById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get().getTitle();
        } else {
            return ("Продукт c id = " + id + " отсутствует");
        }
    }
}
