package ru.myeducation.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext("ru.myeducation.context");
        OrderService orderService = context.getBean(OrderService.class);
        orderService.createOrderFromProduct(1L);

        context.close();
    }
}
