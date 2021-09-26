package parrolabs.coding.test.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import parrolabs.coding.test.entities.Customer;
import parrolabs.coding.test.entities.Order;
import parrolabs.coding.test.entities.OrderItem;
import parrolabs.coding.test.entities.ShippingAddress;
import parrolabs.coding.test.enums.PaymentType;

public class OrderDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String orderNumber;
    private LocalDate date;
    private CustomerDTO customerDTO;
    private ShippingAddressDTO shippingAddressDTO;
    private PaymentType paymentType;
    private List<OrderItemDTO> orderItemsDTO;
    private double totalOrderValue;

    public OrderDTO(Order order) {
	id = order.getId();
	orderNumber = order.getOrderNumber();
	date = order.getDate();
	customerDTO = order.getCustomerDTO();
	shippingAddressDTO = order.getShippingAddressDTO();
	paymentType = order.getPaymentType();
	orderItemsDTO = order.getOrderItemsDTO();
	totalOrderValue = order.getTotalOrderValue();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getOrderNumber() {
	return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
	this.orderNumber = orderNumber;
    }

    public LocalDate getDate() {
	return date;
    }

    public void setDate(LocalDate date) {
	this.date = date;
    }

    public CustomerDTO getCustomerDTO() {
	return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
	this.customerDTO = customerDTO;
    }

    public ShippingAddressDTO getShippingAddressDTO() {
	return shippingAddressDTO;
    }

    public void setShippingAddressDTO(ShippingAddressDTO shippingAddressDTO) {
	this.shippingAddressDTO = shippingAddressDTO;
    }

    public PaymentType getPaymentType() {
	return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
	this.paymentType = paymentType;
    }

    public List<OrderItemDTO> getOrderItemsDTO() {
	return orderItemsDTO;
    }

    public void setOrderItemsDTO(List<OrderItemDTO> orderItemsDTO) {
	this.orderItemsDTO = orderItemsDTO;
    }

    public double getTotalOrderValue() {
	return totalOrderValue;
    }

    public void setTotalOrderValue(double totalOrderValue) {
	this.totalOrderValue = totalOrderValue;
    }

    public Customer getCustomer() {
	return new Customer(customerDTO);
    }

    public ShippingAddress getShippingAddress() {
	return new ShippingAddress(shippingAddressDTO);
    }

    public List<OrderItem> getOrderItems() {
	return orderItemsDTO.stream().map(OrderItem::new).collect(Collectors.toList());
    }

}