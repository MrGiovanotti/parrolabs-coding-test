package parrolabs.coding.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import parrolabs.coding.test.entities.dto.OrderItemDTO;
import parrolabs.coding.test.entities.dto.ProductDTO;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "products_id")
    private Product product;

    int quantity;

    public OrderItem(OrderItemDTO orderItemDTO) {
	id = orderItemDTO.getId();
	product = orderItemDTO.getProduct();
	quantity = orderItemDTO.getQuantity();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Product getProduct() {
	return product;
    }

    public void setProduct(Product producto) {
	product = producto;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    public ProductDTO getProductDTO() {
	return new ProductDTO(product);
    }

}
