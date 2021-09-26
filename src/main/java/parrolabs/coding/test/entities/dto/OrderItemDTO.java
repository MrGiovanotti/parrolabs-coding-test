package parrolabs.coding.test.entities.dto;

import java.io.Serializable;

import org.springframework.lang.NonNull;

import parrolabs.coding.test.entities.OrderItem;
import parrolabs.coding.test.entities.Product;

public class OrderItemDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;

    @NonNull
    ProductDTO productDTO;
    int quantity;

    public OrderItemDTO(OrderItem orderItem) {
	id = orderItem.getId();
	productDTO = orderItem.getProductDTO();
	quantity = orderItem.getQuantity();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public ProductDTO getProductDTO() {
	return productDTO;
    }

    public void setProduct(ProductDTO producto) {
	productDTO = producto;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    public Product getProduct() {
	return new Product(productDTO);
    }
}
