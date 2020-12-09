package com.ifrn.atv3douglasEvinicius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ifrn.atv3douglasEvinicius.model.Turma;
import com.ifrn.atv3douglasEvinicius.repository.TurmaRepository;

@Controller
public class TurmaController {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@GetMapping("/turma")
	public String listarTurmas(Model model) {
		model.addAttribute("listaTurmas", turmaRepository.getAllTurmas());
		return "/turma/list-turma";
	}
	
	@GetMapping("/turma/novo")
	public String newTurma(Model model) {
		model.addAttribute("turma", new Turma());
		return "/turma/new-turma";
	}
	
	@PostMapping("/turma")
	public String saveTurma(@ModelAttribute Turma turma) {
		turmaRepository.save(turma);
		return "redirect:turma";
		
	}
	
}
