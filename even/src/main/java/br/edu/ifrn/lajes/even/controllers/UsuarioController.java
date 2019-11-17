package br.edu.ifrn.lajes.even.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifrn.lajes.even.models.Role;
import br.edu.ifrn.lajes.even.models.Usuario;
import br.edu.ifrn.lajes.even.repositories.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/cadastro")
	public String form() {
		System.out.println("Chamou método do formulárioi");
		return "usuarios/form";
	}

	@PostMapping("/cadastro")
	public String salvar(Usuario usuario) {
		
		ArrayList<Role> roles = new ArrayList<Role>();
		Role role = new Role();
		/* Setando papel de usuário */
		role.setId(2L); 
		roles.add(role);

		usuario.setRoles(roles);

		/* Criptografando senha */
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));

		usuarioRepository.save(usuario);

		return "redirect:/login";
	}

}
