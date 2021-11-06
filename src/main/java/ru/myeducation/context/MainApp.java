package ru.myeducation.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.myeducation.context");
        Cart cart = context.getBean(Cart.class);
        boolean isActive = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавить товар в корзину. Введите:/add productId");
        System.out.println("Удалить товар из корзины. Введите: /del productId");
        System.out.println("Показать содержимое корзины. Введите: /show cart");
        System.out.println("Завершить работу. Введите: /exit");

        while (isActive) {
            System.out.println("ожидаю ввода команды...");
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "/add":
                    cart.addProductById(Long.parseLong(tokens[1]));
                    break;
                case "/del":
                    cart.removeProductById(Long.parseLong(tokens[1]));
                    break;
                case "/show":
                    System.out.println("Содержимое корзины:");
                    cart.showCartContent();
                    break;
                case "/exit":
                    System.out.println("Завершаю работу...");
                    isActive = false;
                    break;
                default:
                    System.out.println("команда введена некорректно ");
            }
        }
        context.close();
    }
}
