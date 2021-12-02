package ru.myeducation.context;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDaoImpl implements ProductDao {
    private SessionFactoryUtils utils;

    @Autowired
    public void setUtils(SessionFactoryUtils utils) {
        this.utils = utils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = utils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Customer> findCustomersByProductId(Long id) {
        try (Session session = utils.getSession()) {
            session.beginTransaction();
//            List<Customer> customerList = session.createNativeQuery("SELECT * FROM customers c JOIN customers_products ON c.id = customers_products.customer_id WHERE product_id = :id", Customer.class)
//                    .setParameter("id", id)
//                    .getResultList();
            Product product = session.get(Product.class, id);
            List<Customer> customerList = product.getCustomers();
            session.getTransaction().commit();
            return customerList;
        }
    }
}
