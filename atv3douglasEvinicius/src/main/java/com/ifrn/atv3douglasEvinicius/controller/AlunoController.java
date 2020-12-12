package com.ifrn.atv3douglasEvinicius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ifrn.atv3douglasEvinicius.model.Aluno;
import com.ifrn.atv3douglasEvinicius.repository.AlunoRespository;
import com.ifrn.atv3douglasEvinicius.repository.OcorrenciaRepository;
import com.ifrn.atv3douglasEvinicius.repository.TurmaRepository;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoRespository alunoRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	
	
	@GetMapping("/aluno/listar-alunos")
	public String detalharAlunos(@RequestParam String nomeTurma,								
								Model model) {
			model.addAttribute("listaAlunos", alunoRepository.getAlunosTurma(nomeTurma));
			model.addAttribute("turma", nomeTurma);
			return "/aluno/detalhes-turma";
	}
	
	@GetMapping("/aluno/novo")
	public String newAluno(Model model) {
		model.addAttribute("aluno", new Aluno());
		return "/aluno/new-aluno";
	}
	
	@PostMapping("/aluno/listar-alunos")
	public String saveAluno(@ModelAttribute Aluno aluno,
							Model model,
							@RequestParam String turmaAluno) {
		aluno.setTurma(turmaRepository.getTurmasEspecifica(turmaAluno));
		alunoRepository.save(aluno);
		return "redirect:/aluno/listar-alunos/?nomeTurma="+aluno.getTurma().getNome();
	}
}
