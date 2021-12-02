package ru.myeducation.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.myeducation.context");

        SessionFactoryUtils utils = new SessionFactoryUtils();
        utils.init();

        CustomerDao customerDao = context.getBean(CustomerDaoImpl.class);
        Customer customer = customerDao.findById(1L);
        System.out.println(customer.getName());
    }
}
