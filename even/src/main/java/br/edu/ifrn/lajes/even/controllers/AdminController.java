package br.edu.ifrn.lajes.even.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifrn.lajes.even.models.Usuario;
import br.edu.ifrn.lajes.even.repositories.UsuarioRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UsuarioRepository ur;
	
	@GetMapping("/usuarios")
	public ModelAndView listaUsuarios() {
		
		Iterable<Usuario> usuarios = ur.findAll();
		
		ModelAndView mv = new ModelAndView("admin/usuarios/lista");
		mv.addObject("usuarios", usuarios);
		
		return mv;
	}

}
