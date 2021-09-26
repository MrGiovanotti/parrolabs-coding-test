package parrolabs.coding.test.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parrolabs.coding.test.entities.OrderItem;
import parrolabs.coding.test.entities.Product;
import parrolabs.coding.test.repositories.ProductRepository;
import parrolabs.coding.test.services.OrderItemService;
import parrolabs.coding.test.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderItemService orderItemService;

    @Override
    public List<Product> findAll() {
	return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
	return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
	return productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
	productRepository.deleteById(id);
    }

    @Override
    public boolean isInAnOrder(Product product) {
	OrderItem orderItem = orderItemService.findByProduct(product);
	return orderItem != null;
    }

}
