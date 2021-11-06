package ru.myeducation.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext("ru.myeducation.context");
        OrderService orderService = context.getBean(OrderService.class);
        Cart cart = context.getBean(Cart.class);
        boolean isActive = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавить товар в корзину. Введите:/add productId");
        System.out.println("Удалить товар из корзины. Введите: /del productId");
        System.out.println("Показать содержимое корзины. Введите: /show cart");
        System.out.println("Завершить работу. Введите: /exit");

        while (isActive){
            System.out.println("ожидаю ввода команды...");
            String line = scanner.nextLine();
            String[]tokens = line.split(" ");
            Arrays.stream(tokens).forEach(System.out::println);
            switch (tokens[0]){
                case "/add":
                    cart.addProductById(Long.parseLong(tokens[1]));
                    System.out.println("Продукт: [" + cart.productService.getTitleById(Long.parseLong(tokens[1])) + "] добавлен в корзину");
                    break;
                case "/del":
                    cart.removeProductById(Long.parseLong(tokens[1]));
                    System.out.println("Продукт: [" + cart.productService.getTitleById(Long.parseLong(tokens[1])) + "] удален из корзины");
                    break;
                case "/show":
                    cart.showCartContent();
                    break;
                case "/exit":
                    isActive = false;
                    break;
                default:
                    System.out.println("команда введена некорректно ");
            }


        }

        //context.close();
    }
}
