package parrolabs.coding.test.services;

import java.util.List;

import parrolabs.coding.test.entities.Product;

public interface ProductService {

    List<Product> findAll();

    Product findById(Integer id);

    Product save(Product product);

    void delete(Integer id);

    boolean isInAnOrder(Product product);

}
