package parrolabs.coding.test.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import parrolabs.coding.test.entities.Order;
import parrolabs.coding.test.entities.dto.OrderDTO;
import parrolabs.coding.test.responses.HttpResponse;
import parrolabs.coding.test.services.OrderService;
import parrolabs.coding.test.utils.Constants;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/list")
    public List<Order> list() {
	return orderService.findAll();
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Map<String, Object>> view(@PathVariable Integer id) {
	Order order = orderService.findById(id);
	if (order != null) {
	    return new HttpResponse(Constants.SUCCESS_MESSAGE, order, HttpStatus.OK).build();
	}
	return new HttpResponse(Constants.NOT_FOUND_MESSAGE, order, HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody OrderDTO orderDTO, BindingResult result) {
	if (result.hasErrors()) {
	    return new HttpResponse(Constants.VALIDATION_ERROR_MESSAGE, null, HttpStatus.BAD_REQUEST).build();
	}
	Order order = new Order(orderDTO);
	order.calculateTotalOrderValue();
	try {
	    orderService.save(order);
	    return new HttpResponse(Constants.SUCCESS_MESSAGE, order, HttpStatus.OK).build();
	} catch (Exception e) {
	    return new HttpResponse(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
    }

    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> update(@Validated @RequestBody OrderDTO orderDTO, BindingResult result) {
	if (result.hasErrors()) {
	    return new HttpResponse(Constants.VALIDATION_ERROR_MESSAGE, null, HttpStatus.BAD_REQUEST).build();
	}

	Order currentOrder = orderService.findById(orderDTO.getId());

	if (currentOrder == null) {
	    return new HttpResponse(Constants.NOT_FOUND_MESSAGE, null, HttpStatus.NOT_FOUND).build();
	}

	currentOrder.setCustomer(orderDTO.getCustomer());
	currentOrder.setDate(orderDTO.getDate());
	currentOrder.setOrderItems(orderDTO.getOrderItems());
	currentOrder.setOrderNumber(orderDTO.getOrderNumber());
	currentOrder.setPaymentType(orderDTO.getPaymentType());
	currentOrder.setShippingAddress(orderDTO.getShippingAddress());
	currentOrder.calculateTotalOrderValue();

	try {
	    orderService.save(currentOrder);
	    return new HttpResponse(Constants.SUCCESS_MESSAGE, currentOrder, HttpStatus.OK).build();
	} catch (Exception e) {
	    return new HttpResponse(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Integer id) {
	Order order = orderService.findById(id);
	if (order == null) {
	    return new HttpResponse(Constants.NOT_FOUND_MESSAGE, null, HttpStatus.NOT_FOUND).build();
	}
	orderService.delete(id);
	return new HttpResponse(Constants.SUCCESS_MESSAGE, order, HttpStatus.OK).build();
    }

}
