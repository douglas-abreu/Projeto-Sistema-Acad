package com.ifrn.atv3douglasEvinicius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String saveTurma(@ModelAttribute Turma turma,
							@RequestParam(required = false) String edit,
							RedirectAttributes redirect){
		if(edit == null) {
			turmaRepository.save(turma);
			redirect.addFlashAttribute("msg", "Turma "+turma.getCodigo()+" adicionada com sucesso!");
		}else {
			turmaRepository.atualizar(turma);
			redirect.addFlashAttribute("msg", "Turma "+turma.getCodigo()+" atualizada com sucesso!");
		}
		return "redirect:/turma";
	}
	
	@GetMapping("/turma/deletar/{codigo}")
	public String deleteTurma(@PathVariable("codigo") String codigo,
							  RedirectAttributes redirect) {
		turmaRepository.deleteTurma(codigo);
		redirect.addFlashAttribute("msg", "Turma "+codigo+" deletada com sucesso!");
		return "redirect:/turma";
	}
	
	@GetMapping("/turma/editar/{codigo}")
	public String editarTurma(@PathVariable("codigo") String codigo,
							  Model model) {
		model.addAttribute("turma", turmaRepository.getTurmasEspecifica(codigo));
		return "/turma/new-turma";
	}
}
