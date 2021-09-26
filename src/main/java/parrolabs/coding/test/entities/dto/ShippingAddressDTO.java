package parrolabs.coding.test.entities.dto;

import java.io.Serializable;

import parrolabs.coding.test.entities.ShippingAddress;

public class ShippingAddressDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String streetAndNumber;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public ShippingAddressDTO(ShippingAddress shippingAddress) {
	id = shippingAddress.getId();
	streetAndNumber = shippingAddress.getStreetAndNumber();
	city = shippingAddress.getCity();
	state = shippingAddress.getState();
	zipCode = shippingAddress.getZipCode();
	country = shippingAddress.getCountry();
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

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

}
