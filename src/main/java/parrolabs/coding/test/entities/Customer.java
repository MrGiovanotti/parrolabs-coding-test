package parrolabs.coding.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import parrolabs.coding.test.entities.dto.CustomerDTO;
import parrolabs.coding.test.entities.dto.ShippingAddressDTO;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "shipping_addresses_id")
    private ShippingAddress primaryShippingAddress;

    public Customer(CustomerDTO customerDTO) {
	id = customerDTO.getId();
	name = customerDTO.getName();
	phone = customerDTO.getPhone();
	email = customerDTO.getEmail();
	primaryShippingAddress = customerDTO.getPrimaryShippingAddress();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public ShippingAddress getPrimaryShippingAddress() {
	return primaryShippingAddress;
    }

    public void setPrimaryShippingAddress(ShippingAddress primaryShippingAddress) {
	this.primaryShippingAddress = primaryShippingAddress;
    }

    public ShippingAddressDTO getPrimaryShippingAddressDTO() {
	return new ShippingAddressDTO(primaryShippingAddress);
    }

}
