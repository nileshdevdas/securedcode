package com.vinsys.security.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vinsys.security.vo.Customer;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

	@PostMapping(consumes = "application/json")
	public String createCustomer(@Valid @RequestBody Customer customer) {
		String result = "  You Paid " + (customer.getQuantity() * 100);
		return result;
	}
}
