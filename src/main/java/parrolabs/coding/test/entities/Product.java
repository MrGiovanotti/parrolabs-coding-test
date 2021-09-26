package parrolabs.coding.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import parrolabs.coding.test.entities.dto.ProductDTO;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private double price;
    private double weight;

    public Product(ProductDTO productDTO) {
	id = productDTO.getId();
	description = productDTO.getDescription();
	price = productDTO.getPrice();
	weight = productDTO.getWeight();
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
