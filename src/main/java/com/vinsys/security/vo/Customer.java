package com.vinsys.security.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {

	@NotBlank
	@NotNull
	@Size(min = 3, max = 20, message = "Your field is to short or too long")
	private String customerName;

	@Email
	@NotNull
	@NotBlank
	private String email;

	@Min(1)
	@Max(100)
	private Long quantity;

	@Pattern(regexp = "^[A-Za-z0-9]{3}")
	@NotNull
	@NotBlank
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
