package ru.myeducation.context;

import java.util.List;

public interface CustomerDao {

    Customer findById(Long id);

    List<Product> findProductsByCustomerId(Long id);

}
