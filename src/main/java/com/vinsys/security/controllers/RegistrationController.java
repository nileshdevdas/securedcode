package com.vinsys.security.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin(origins = "*")
public class RegistrationController {

	@PostMapping(path = "/register")
	public void registerAndSendMail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String comment = request.getParameter("comment");
		System.out.println("Sending Mail .......................");
		PrintWriter writer = response.getWriter();
		writer.write("Thank You For Registering");
		writer.flush();
	}

	@GetMapping(path = "/register")
	public void registerGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		writer.write("Thank You For Registering");
		writer.flush();
	}
}
