package parrolabs.coding.test.entities.dto;

import java.io.Serializable;

import parrolabs.coding.test.entities.Product;

public class ProductDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String description;
    private double price;
    private double weight;

    public ProductDTO(Product product) {
	id = product.getId();
	description = product.getDescription();
	price = product.getPrice();
	weight = product.getWeight();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public double getWeight() {
	return weight;
    }

    public void setWeight(double weight) {
	this.weight = weight;
    }

}
