package parrolabs.coding.test.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parrolabs.coding.test.entities.Customer;
import parrolabs.coding.test.entities.Order;
import parrolabs.coding.test.repositories.OrderRepository;
import parrolabs.coding.test.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
	return orderRepository.findAll();
    }

    @Override
    public Order findById(Integer id) {
	return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order save(Order order) {
	return orderRepository.save(order);
    }

    @Override
    public void delete(Integer id) {
	orderRepository.deleteById(id);
    }

    @Override
    public Order findByCustomer(Customer customer) {
	return orderRepository.findByCustomer(customer);
    }

}
