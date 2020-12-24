package com.ifrn.atv3douglasEvinicius.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifrn.atv3douglasEvinicius.model.Aluno;
import com.ifrn.atv3douglasEvinicius.model.Ocorrencia;
import com.ifrn.atv3douglasEvinicius.model.StatusOcorrencia;
import com.ifrn.atv3douglasEvinicius.repository.AlunoRespository;
import com.ifrn.atv3douglasEvinicius.repository.OcorrenciaRepository;

@Controller
public class OcorrenciaController {

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	private AlunoRespository alunoRepository;
	
	@GetMapping("/ocorrencia/listar-ocorrencias")
	public String detalharOcorrencias(@RequestParam String matricula,								
								Model model) {
			model.addAttribute("listaOcorrencias", ocorrenciaRepository.getOcorrenciaPerAluno(matricula));
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
		model.addAttribute("status",ocorrenciaRepository.getAllOcorrenciaStatus());
		model.addAttribute("alunos",alunoRepository.getAllAlunos());
		return "/ocorrencia/new-ocorrencia";
	}
	
	@PostMapping("/ocorrencia")
	public String saveOcorrencia(@ModelAttribute Ocorrencia ocorrencia,
			@RequestParam String alunoSelected,
			@RequestParam(required = false) String edit,
			RedirectAttributes redirect,
			Model model) {
	    ocorrencia.setDataHora(new Date());
	    ocorrencia.setAluno(alunoRepository.getAlunoNome(alunoSelected));
		if(edit == null) {
		
		    ocorrenciaRepository.save(ocorrencia);
		    redirect.addFlashAttribute("msg", "Ocorrência "+ocorrencia.getId()+" criada com sucesso!");
		}else {
		    ocorrenciaRepository.atualizar(ocorrencia);
		    redirect.addFlashAttribute("msg", "Ocorrência "+ocorrencia.getId()+" atualizada com sucesso!");
		}
		return "redirect:/ocorrencia/listar-ocorrencias?matricula="+ocorrencia.getAluno().getMatricula();
	}
	
	
	@GetMapping("/ocorrencia/deletar/{id}")
	public String deleteOcorrencia(@PathVariable("id") String id,
			RedirectAttributes redirect) {
	  Ocorrencia ocorr = ocorrenciaRepository.getOcorrenciaEspecifica(Integer.parseInt(id));
		ocorrenciaRepository.getAllOcorrencias().remove(ocorr);
		redirect.addFlashAttribute("msg", "Ocorrencia "+ocorr.getId()+" removida com sucesso!");
		return "redirect:/ocorrencia/listar-ocorrencias?matricula="+ocorr.getAluno().getMatricula();
	}
	
	@GetMapping("/ocorrencia/editar/{id}")
	public String editarOcorrencia(@PathVariable("id") String id,
								   RedirectAttributes redirect,
							       Model model) {
		
		model.addAttribute("ocorrencia", ocorrenciaRepository.getOcorrenciaEspecifica(Integer.parseInt(id)));
		model.addAttribute("alunos", alunoRepository.getAllAlunos());
		model.addAttribute("status", StatusOcorrencia.values());
		redirect.addFlashAttribute("msg", "Ocorrência "+id+" atualizada com sucesso!");
		return "/ocorrencia/new-ocorrencia";
	}
	
}
