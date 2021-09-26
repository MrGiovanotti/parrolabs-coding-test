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

import parrolabs.coding.test.entities.Product;
import parrolabs.coding.test.entities.dto.ProductDTO;
import parrolabs.coding.test.responses.HttpResponse;
import parrolabs.coding.test.services.ProductService;
import parrolabs.coding.test.utils.Constants;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public List<Product> list() {
	return productService.findAll();
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Map<String, Object>> view(@PathVariable Integer id) {
	Product product = productService.findById(id);
	if (product != null) {
	    return new HttpResponse(Constants.SUCCESS_MESSAGE, product, HttpStatus.OK).build();
	}
	return new HttpResponse(Constants.NOT_FOUND_MESSAGE, product, HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody ProductDTO productDTO,
	    BindingResult result) {
	if (result.hasErrors()) {
	    return new HttpResponse(Constants.VALIDATION_ERROR_MESSAGE, null, HttpStatus.BAD_REQUEST).build();
	}
	Product product = new Product(productDTO);
	try {
	    productService.save(product);
	    return new HttpResponse(Constants.SUCCESS_MESSAGE, product, HttpStatus.OK).build();
	} catch (Exception e) {
	    return new HttpResponse(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
    }

    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> update(@Validated @RequestBody ProductDTO productDTO,
	    BindingResult result) {
	if (result.hasErrors()) {
	    return new HttpResponse(Constants.VALIDATION_ERROR_MESSAGE, null, HttpStatus.BAD_REQUEST).build();
	}

	Product currentProduct = productService.findById(productDTO.getId());

	if (currentProduct == null) {
	    return new HttpResponse(Constants.NOT_FOUND_MESSAGE, null, HttpStatus.NOT_FOUND).build();
	}

	currentProduct.setPrice(productDTO.getPrice());
	currentProduct.setWeight(productDTO.getWeight());
	currentProduct.setDescription(productDTO.getDescription());

	try {
	    productService.save(currentProduct);
	    return new HttpResponse(Constants.SUCCESS_MESSAGE, currentProduct, HttpStatus.OK).build();
	} catch (Exception e) {
	    return new HttpResponse(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Integer id) {
	Product product = productService.findById(id);
	if (product == null) {
	    return new HttpResponse(Constants.NOT_FOUND_MESSAGE, null, HttpStatus.NOT_FOUND).build();
	}
	if (productService.isInAnOrder(product)) {
	    return new HttpResponse("Customer has already an order", null, HttpStatus.CONFLICT).build();
	}
	productService.delete(id);
	return new HttpResponse(Constants.SUCCESS_MESSAGE, product, HttpStatus.OK).build();
    }

}
