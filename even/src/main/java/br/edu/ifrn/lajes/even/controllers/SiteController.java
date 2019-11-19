package br.edu.ifrn.lajes.even.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

	@GetMapping("/")
	public String index() {
		return "site/index";
	}

	@GetMapping("/noticias")
	public String noticias() {
		return "site/noticias";
	}

	@GetMapping("/programacao")
	public String programacao() {
		return "site/programacao";
	}

	@GetMapping("/regulamentos")
	public String regulamentos() {
		return "site/regulamentos";
	}

	@GetMapping("/fotos")
	public String fotos() {
		return "site/fotos";
	}

}
