package parrolabs.coding.test.services;

import java.util.List;

import parrolabs.coding.test.entities.Customer;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Integer id);

    Customer save(Customer customer);

    void delete(Integer id);

    boolean hasAnOrder(Customer customer);

}
