package ru.myeducation.context;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.myeducation.context");

        SessionFactoryUtils utils = new SessionFactoryUtils();
        utils.init();

        CustomerDao customerDao = context.getBean(CustomerDaoImpl.class);
        ProductDao productDao = context.getBean(ProductDaoImpl.class);

        System.out.println(customerDao.findById(1L).getName());
    }
}
