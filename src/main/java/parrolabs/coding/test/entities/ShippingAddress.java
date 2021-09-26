package parrolabs.coding.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import parrolabs.coding.test.entities.dto.ShippingAddressDTO;

@Entity
@Table(name = "shipping_addresses")
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "street_and_number")
    private String streetAndNumber;

    private String city;
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    private String country;

    public ShippingAddress(ShippingAddressDTO shippingAddressDTO) {
	id = shippingAddressDTO.getId();
	streetAndNumber = shippingAddressDTO.getStreetAndNumber();
	city = shippingAddressDTO.getCity();
	state = shippingAddressDTO.getState();
	zipCode = shippingAddressDTO.getZipCode();
	country = shippingAddressDTO.getCountry();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getStreetAndNumber() {
	return streetAndNumber;
    }

    public void setStreetAndNumber(String streetAndNumber) {
	this.streetAndNumber = streetAndNumber;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getZipCode() {
	return zipCode;
    }

    public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

}
