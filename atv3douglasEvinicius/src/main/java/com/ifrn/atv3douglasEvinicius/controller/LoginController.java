package com.ifrn.atv3douglasEvinicius.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ifrn.atv3douglasEvinicius.model.Usuario;
import com.ifrn.atv3douglasEvinicius.repository.UsuarioRepository;

@Controller
public class LoginController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/login")
	public String login() {		
		return "/login/login";
	}
	
	@PostMapping("/login")
	public String logar(@RequestParam("login") String login,
			@RequestParam("senha") String senha, HttpSession session){
		Usuario userLocal = usuarioRepository.verificar(login,senha);
		if(userLocal != null) {
			session.setAttribute("userLocal", userLocal);
		}
		return "redirect:/turma";
	}
	
	@GetMapping("/logout")
	public String sair(HttpSession session){
		session.invalidate();
		return "redirect:/turma";
	}
}
