package com.ifrn.atv3douglasEvinicius.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ifrn.atv3douglasEvinicius.model.Aluno;
import com.ifrn.atv3douglasEvinicius.repository.AlunoRespository;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoRespository alunoRepository;
	
	@GetMapping("/aluno/listar-alunos")
	public String detalharAlunos(@RequestParam String nomeTurma,
								Model model) {
		 model.addAttribute("listaAlunos", alunoRepository.getAlunosTurma(nomeTurma));
		 return "/aluno/detalhes-turma";
	}
}
