package br.edu.ifrn.lajes.even.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {
	
	@GetMapping("/")
	public String index() {
		System.out.println("Chamou o método index");
		return "index";
	}

}
