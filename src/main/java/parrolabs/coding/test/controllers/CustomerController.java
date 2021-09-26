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

import parrolabs.coding.test.entities.Customer;
import parrolabs.coding.test.entities.dto.CustomerDTO;
import parrolabs.coding.test.responses.HttpResponse;
import parrolabs.coding.test.services.CustomerService;
import parrolabs.coding.test.utils.Constants;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public List<Customer> list() {
	return customerService.findAll();
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Map<String, Object>> view(@PathVariable Integer id) {
	Customer customer = customerService.findById(id);
	if (customer != null) {
	    return new HttpResponse(Constants.SUCCESS_MESSAGE, customer, HttpStatus.OK).build();
	}
	return new HttpResponse(Constants.NOT_FOUND_MESSAGE, customer, HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody CustomerDTO customerDTO,
	    BindingResult result) {
	if (result.hasErrors()) {
	    return new HttpResponse(Constants.VALIDATION_ERROR_MESSAGE, null, HttpStatus.BAD_REQUEST).build();
	}
	Customer customer = new Customer(customerDTO);
	try {
	    customerService.save(customer);
	    return new HttpResponse(Constants.SUCCESS_MESSAGE, customer, HttpStatus.OK).build();
	} catch (Exception e) {
	    return new HttpResponse(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
    }

    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> update(@Validated @RequestBody CustomerDTO customerDTO,
	    BindingResult result) {
	if (result.hasErrors()) {
	    return new HttpResponse(Constants.VALIDATION_ERROR_MESSAGE, null, HttpStatus.BAD_REQUEST).build();
	}

	Customer currentCustomer = customerService.findById(customerDTO.getId());

	if (currentCustomer == null) {
	    return new HttpResponse(Constants.NOT_FOUND_MESSAGE, null, HttpStatus.NOT_FOUND).build();
	}

	currentCustomer.setName(customerDTO.getName());
	currentCustomer.setPhone(customerDTO.getPhone());
	currentCustomer.setEmail(currentCustomer.getEmail());
	currentCustomer.setPrimaryShippingAddress(currentCustomer.getPrimaryShippingAddress());
	try {
	    customerService.save(currentCustomer);
	    return new HttpResponse(Constants.SUCCESS_MESSAGE, currentCustomer, HttpStatus.OK).build();
	} catch (Exception e) {
	    return new HttpResponse(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Integer id) {
	Customer customer = customerService.findById(id);
	if (customer == null) {
	    return new HttpResponse(Constants.NOT_FOUND_MESSAGE, null, HttpStatus.NOT_FOUND).build();
	}
	if (customerService.hasAnOrder(customer)) {
	    return new HttpResponse("Customer has already an order", null, HttpStatus.CONFLICT).build();
	}
	customerService.delete(id);
	return new HttpResponse(Constants.SUCCESS_MESSAGE, customer, HttpStatus.OK).build();
    }

}
