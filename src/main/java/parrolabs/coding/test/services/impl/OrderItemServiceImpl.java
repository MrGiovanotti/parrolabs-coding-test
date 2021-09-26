package parrolabs.coding.test.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parrolabs.coding.test.entities.OrderItem;
import parrolabs.coding.test.entities.Product;
import parrolabs.coding.test.repositories.OrderItemRepository;
import parrolabs.coding.test.services.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public OrderItem findByProduct(Product product) {
	return orderItemRepository.findByProduct(product);
    }

}
