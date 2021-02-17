package com.example.sociallogindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping (value = { "/", "/home" })
	public String homepage() {
		return "home"; // Trả về home.html
	}

	@RequestMapping ("/login")
	public String login() {
		return "login";
	}

}