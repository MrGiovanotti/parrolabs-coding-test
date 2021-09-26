package parrolabs.coding.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import parrolabs.coding.test.entities.Customer;
import parrolabs.coding.test.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findByCustomer(Customer customer);

}
