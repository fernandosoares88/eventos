package br.edu.ifrn.lajes.even.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login/login";
	}

	@GetMapping("/logout")
	public String logout() {
		return "login/logout";
	}

}
