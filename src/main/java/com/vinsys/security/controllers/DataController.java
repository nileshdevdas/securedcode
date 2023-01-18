package com.vinsys.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/data")
public class DataController {

	@GetMapping
	public String home(HttpServletResponse response) {
		return "Home";
	}
}
