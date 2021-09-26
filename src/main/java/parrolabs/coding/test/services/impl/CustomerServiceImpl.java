package parrolabs.coding.test.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parrolabs.coding.test.entities.Customer;
import parrolabs.coding.test.entities.Order;
import parrolabs.coding.test.repositories.CustomerRepository;
import parrolabs.coding.test.services.CustomerService;
import parrolabs.coding.test.services.OrderService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderService orderService;

    @Override
    public List<Customer> findAll() {
	return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
	return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
	return customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
	customerRepository.deleteById(id);
    }

    @Override
    public boolean hasAnOrder(Customer customer) {
	Order order = orderService.findByCustomer(customer);
	return order != null;
    }

}
