package com.ifrn.atv3douglasEvinicius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifrn.atv3douglasEvinicius.model.Ocorrencia;
import com.ifrn.atv3douglasEvinicius.model.Turma;
import com.ifrn.atv3douglasEvinicius.model.Usuario;
import com.ifrn.atv3douglasEvinicius.repository.UsuarioRepository;

@Controller
public class UsuarioController {
  
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuario/listar-usuarios")
	public String listarUsuarios(Model model) {
		model.addAttribute("listaUsuarios", usuarioRepository.getAllUsers());
		return "/usuario/list-usuario";
	}
	
	@GetMapping("/usuario/novo")
	public String newAluno(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("funcao",usuarioRepository.getAllFuncao());
		return "/usuario/new-usuario";
	}
	
	@PostMapping("/usuario/listar-usuarios")
	public String saveTurma(@ModelAttribute Usuario user,
							RedirectAttributes redirect){
			usuarioRepository.save(user);
			redirect.addFlashAttribute("msg", "Usuário "+ user.getNome()+" adicionada com sucesso!");
	
		return "redirect:/usuario/listar-usuarios";
	}
	
}
