package parrolabs.coding.test.entities.dto;

import java.io.Serializable;

import parrolabs.coding.test.entities.Customer;
import parrolabs.coding.test.entities.ShippingAddress;

public class CustomerDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String phone;
    private String email;
    private ShippingAddressDTO primaryShippingAddress;

    public CustomerDTO(Customer customer) {
	id = customer.getId();
	name = customer.getName();
	phone = customer.getPhone();
	email = customer.getEmail();
	primaryShippingAddress = customer.getPrimaryShippingAddressDTO();
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

    public ShippingAddressDTO getPrimaryShippingAddressDTO() {
	return primaryShippingAddress;
    }

    public void setPrimaryShippingAddressDTO(ShippingAddressDTO primaryShippingAddressDTO) {
	primaryShippingAddress = primaryShippingAddressDTO;
    }

    public ShippingAddress getPrimaryShippingAddress() {
	return new ShippingAddress(primaryShippingAddress);
    }

}
