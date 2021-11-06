package ru.myeducation.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public void addProductById(Long id){
        if (productRepository.findById(id)!=null){
            products.add(productRepository.findById(id));
        }else {
            System.out.println("Продукт отсутствует");
        }
    }

    public void removeProductById(Long id){
        products.remove(productRepository.getProducts().stream().filter(p-> p.getId()==id).findFirst().orElseThrow(()->new RuntimeException("Нет такого продукта")));
    }

    public void showCartContent(){
        products.stream().forEach(System.out::println);
    }
}
