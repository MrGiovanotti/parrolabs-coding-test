package parrolabs.coding.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import parrolabs.coding.test.entities.OrderItem;
import parrolabs.coding.test.entities.Product;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    OrderItem findByProduct(Product product);

}
