package ru.myeducation.context;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDaoImpl implements CustomerDao {
    private SessionFactoryUtils utils;

    @Autowired
    public void setUtils(SessionFactoryUtils utils) {
        this.utils = utils;
    }

    @Override
    public Customer findById(Long id) {
        try (Session session = utils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public List<Product> findProductsByCustomerId(Long id) {
        try (Session session = utils.getSession()) {
            session.beginTransaction();
//            List<Product> productList = session.createNativeQuery("SELECT * FROM products p JOIN customers_products ON p.id = customers_products.product_id WHERE customer_id = :id", Product.class)
//                    .setParameter("id", id)
//                    .getResultList();
            Customer customer = session.get(Customer.class, id);
            List<Product> productList = customer.getProducts();
            session.getTransaction().commit();
            return productList;
        }
    }
}
