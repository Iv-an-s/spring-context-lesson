package ru.myeducation.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope("prototype")
public class Cart {
    ProductRepository productRepository;
    ProductService productService;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    List<Product> products = new ArrayList<>();

    public void addProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            products.add(product.get());
            System.out.println("Продукт " + productService.getTitleById(id) + " добавлен в корзину");
        } else {
            System.out.println("Продукт c id = " + id + " отсутствует");
        }
    }

    public void removeProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            if(products.remove(product.get())){
                System.out.println("Продукт " + productService.getTitleById(id) + " удален из корзины");
            }else{
                System.out.println("Продукт " + productService.getTitleById(id) + " в корзине отсутствует");
            }
        } else {
            System.out.println("Продукта c id = " + id + " не существует");
        }
    }

    public void showCartContent() {
        products.stream().forEach(System.out::println);
    }
}

