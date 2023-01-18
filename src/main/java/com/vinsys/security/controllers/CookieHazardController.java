package com.vinsys.security.controllers;

import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/cookies")
public class CookieHazardController {

	@GetMapping
	public void addCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie = new Cookie("authToken", "29389283lkJAlkajzlkjzsdfkjsafd");
		Cookie cookie2 = new Cookie("profile", "NileshD");
		cookie.setMaxAge(-1);
		cookie.setHttpOnly(true);
		cookie2.setMaxAge(-1);
		cookie2.setHttpOnly(true);
		cookie.setAttribute("SameSite", "true");
		cookie.setSecure(true);
		cookie2.setSecure(true);
		response.addCookie(cookie);
		response.addCookie(cookie2);
	}

	@GetMapping(path = "/sense")
	public void senseCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookies[] = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getValue());
		}
	}
}
