package parrolabs.coding.test.services;

import java.util.List;

import parrolabs.coding.test.entities.Customer;
import parrolabs.coding.test.entities.Order;

public interface OrderService {

    List<Order> findAll();

    Order findById(Integer id);

    Order save(Order order);

    void delete(Integer id);

    Order findByCustomer(Customer customer);

}
