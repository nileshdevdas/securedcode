package com.vinsys.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/register1")
public class PostController {

	@PostMapping
	public void registerUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("firstname"));
		System.out.println(request.getParameter("lastname"));
		response.setStatus(HttpServletResponse.SC_OK);
	}
}
