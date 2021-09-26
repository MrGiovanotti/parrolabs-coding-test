package parrolabs.coding.test.services;

import parrolabs.coding.test.entities.OrderItem;
import parrolabs.coding.test.entities.Product;

public interface OrderItemService {

    OrderItem findByProduct(Product product);

}
