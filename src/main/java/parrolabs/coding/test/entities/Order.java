package parrolabs.coding.test.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import parrolabs.coding.test.entities.dto.CustomerDTO;
import parrolabs.coding.test.entities.dto.OrderDTO;
import parrolabs.coding.test.entities.dto.OrderItemDTO;
import parrolabs.coding.test.entities.dto.ShippingAddressDTO;
import parrolabs.coding.test.enums.PaymentType;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_number", unique = true)
    private String orderNumber;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "customers_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shipping_addresses_id")
    private ShippingAddress shippingAddress;

    @Column(name = "payment_type")
    private PaymentType paymentType;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems;

    @Column(name = "total_order_value")
    private double totalOrderValue;

    public Order() {
	orderItems = new ArrayList<>();
    }

    public Order(OrderDTO orderDTO) {
	id = orderDTO.getId();
	orderNumber = orderDTO.getOrderNumber();
	date = orderDTO.getDate();
	customer = orderDTO.getCustomer();
	shippingAddress = orderDTO.getShippingAddress();
	paymentType = orderDTO.getPaymentType();
	orderItems = orderDTO.getOrderItems();
	totalOrderValue = orderDTO.getTotalOrderValue();
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

    public Customer getCustomer() {
	return customer;
    }

    public void setCustomer(Customer customer) {
	this.customer = customer;
    }

    public ShippingAddress getShippingAddress() {
	return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
	this.shippingAddress = shippingAddress;
    }

    public PaymentType getPaymentType() {
	return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
	this.paymentType = paymentType;
    }

    public List<OrderItem> getOrderItems() {
	return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
	this.orderItems = orderItems;
    }

    public double getTotalOrderValue() {
	return totalOrderValue;
    }

    public void setTotalOrderValue(double totalOrderValue) {
	this.totalOrderValue = totalOrderValue;
    }

    public CustomerDTO getCustomerDTO() {
	return new CustomerDTO(customer);
    }

    public ShippingAddressDTO getShippingAddressDTO() {
	return new ShippingAddressDTO(shippingAddress);
    }

    public List<OrderItemDTO> getOrderItemsDTO() {
	return orderItems.stream().map(OrderItemDTO::new).collect(Collectors.toList());
    }

    public void calculateTotalOrderValue() {
	double total = 0;
	List<Double> pricesList = orderItems.stream()
		.map(orderItem -> orderItem.getProduct().getPrice() * orderItem.getQuantity())
		.collect(Collectors.toList());
	for (double price : pricesList) {
	    total = price + total;
	}
	totalOrderValue = total;

    }

}
