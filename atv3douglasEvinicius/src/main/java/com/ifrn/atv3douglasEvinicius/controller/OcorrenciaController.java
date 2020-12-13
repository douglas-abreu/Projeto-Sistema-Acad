package com.ifrn.atv3douglasEvinicius.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ifrn.atv3douglasEvinicius.model.Aluno;
import com.ifrn.atv3douglasEvinicius.model.Ocorrencia;
import com.ifrn.atv3douglasEvinicius.repository.AlunoRespository;
import com.ifrn.atv3douglasEvinicius.repository.OcorrenciaRepository;

@Controller
public class OcorrenciaController {

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	private AlunoRespository alunoRepository;
	
	@GetMapping("/ocorrencia/listar-ocorrencias")
	public String detalharOcorrencias(@RequestParam String nomeAluno,								
								Model model) {
			model.addAttribute("listaOcorrencias", ocorrenciaRepository.getOcorrenciaPerAluno( nomeAluno));
			//model.addAttribute("turma", nomeOcorrencia);
			return "/ocorrencia/detalhes-ocorrencia";
	}
	

	@GetMapping("/ocorrencia")
	public String detalharOcorrencias(Model model) {
		model.addAttribute("listaOcorrencias", ocorrenciaRepository.getAllOcorrencias());
		return "/ocorrencia/detalhes-ocorrencia";
	}
	
	@GetMapping("/ocorrencia/novo")
	public String newAluno(Model model) {
		model.addAttribute("ocorrencia", new Ocorrencia());
		return "/ocorrencia/new-ocorrencia";
	}
	
	@PostMapping("/ocorrencia")
	public String saveOcorrencia(@ModelAttribute Ocorrencia ocorrencia,
			@RequestParam String alunoOcorrencia,
							Model model) {
		System.out.println("entrou no POST de ocorrencia!");
	    ocorrencia.setDataHora(new Date());
	    ocorrencia.setAluno(alunoRepository.getAlunosEspecifica(alunoOcorrencia));
		ocorrenciaRepository.save(ocorrencia);
		return "redirect:ocorrencia/listar-ocorrencias?nomeAluno="+ocorrencia.getAluno().getNome();
	}
	
}
