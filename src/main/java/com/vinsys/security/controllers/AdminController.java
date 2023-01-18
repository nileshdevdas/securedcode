package com.vinsys.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

	@GetMapping
	public String home(HttpServletResponse response) {
		Cookie cookie = new Cookie("mypass", "sdsdsdsd");
		cookie.setMaxAge(-1);
		cookie.setDomain("");
		response.addCookie(cookie);

		return "Home";
	}
}
