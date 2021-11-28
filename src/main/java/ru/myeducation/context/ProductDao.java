package ru.myeducation.context;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    List<Customer> findCustomersByProductId(Long id);
}
