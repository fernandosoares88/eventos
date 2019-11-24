package br.edu.ifrn.lajes.even.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifrn.lajes.even.models.Role;
import br.edu.ifrn.lajes.even.models.Usuario;
import br.edu.ifrn.lajes.even.repositories.RoleRepository;
import br.edu.ifrn.lajes.even.repositories.UsuarioRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UsuarioRepository ur;
	@Autowired
	RoleRepository rr;

	@GetMapping("/usuarios")
	public ModelAndView listaUsuarios(String filter) {

		if (filter == null)
			filter = "";

		Iterable<Usuario> usuarios = ur.findAllByNomeContaining(filter);

		ModelAndView mv = new ModelAndView("admin/usuarios/lista");
		mv.addObject("usuarios", usuarios);

		return mv;
	}

	@GetMapping("/usuarios/{id}")
	public ModelAndView selecionaUsuario(@PathVariable("id") Long id) {
		Usuario usuario = ur.findById(id).get();
		Iterable<Role> papeis = rr.findAll();
		
		ModelAndView mv = new ModelAndView("admin/usuarios/form");
		mv.addObject("usuario", usuario);
		mv.addObject("papeis", papeis);

		return mv;
	}
	
	@PostMapping("/usuarios/{id}")
	public String salvarPapeisUsuario(Usuario usuarioForm) {
		
		System.out.println("Chamou método de salvar papeis do usuário");
		
		
		Usuario usuario = ur.findById(usuarioForm.getId()).get();
		if(usuario == null) {
			return "redirect:/admin/usuarios/";
		}
		usuario.setRoles(usuarioForm.getRoles());
		
		
		System.out.println("Usuario form: " + usuarioForm);
		System.out.println("Usuario editado: " + usuario);
		
		ur.save(usuario);
		
		return "redirect:/admin/usuarios/" + usuarioForm.getId();
	}

}
