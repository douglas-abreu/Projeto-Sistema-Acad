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

import com.ifrn.atv3douglasEvinicius.model.Aluno;
import com.ifrn.atv3douglasEvinicius.repository.AlunoRespository;
import com.ifrn.atv3douglasEvinicius.repository.TurmaRepository;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoRespository alunoRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@GetMapping("/aluno/listar-alunos")
	public String detalharAlunos(@RequestParam(required=false) String codigo,								
								Model model) {
			model.addAttribute("listaAlunos", alunoRepository.getAlunosTurma(codigo));
			model.addAttribute("turma", turmaRepository.getTurmasEspecifica(codigo));
			return "/aluno/detalhes-turma";
	}
	
	
	@GetMapping("/aluno/novo")
	public String newAluno(Model model) {
		model.addAttribute("aluno", new Aluno());
		model.addAttribute("turmas", turmaRepository.getAllTurmas());
		return "/aluno/new-aluno";
	}
	
	@PostMapping("/aluno/listar-alunos")
	public String saveAluno(@ModelAttribute Aluno aluno,
							Model model,
							@RequestParam String codigo,
							@RequestParam(required = false) String edit,
							RedirectAttributes redirect) {
		aluno.setTurma(turmaRepository.getTurmasEspecifica(codigo));
		if(edit == null) {
			alunoRepository.save(aluno);
			redirect.addFlashAttribute("msg", "Aluno "+aluno.getNome()+" adicionada com sucesso!");
		}else {
			alunoRepository.atualizar(aluno);
			redirect.addFlashAttribute("msg", "Aluno "+aluno.getNome()+" atualizado com sucesso!");
		}
		
		return "redirect:/aluno/listar-alunos/?codigo="+codigo;
	}
	
	@GetMapping("/aluno/deletar/{codigo}/{matricula}")
	public String deleteAluno(@PathVariable("matricula") String matricula,
							  @PathVariable("codigo") String codigo,
							  RedirectAttributes redirect) {
		Aluno aluno = alunoRepository.getAlunosEspecifica(matricula);
		alunoRepository.getAllAlunos().remove(aluno);
		redirect.addFlashAttribute("msg", "Aluno(a) "+aluno.getNome()+" deletado(a) com sucesso!");
		return "redirect:/aluno/listar-alunos/?codigo="+codigo;
	}
	
	@GetMapping("/aluno/editar/{matricula}")
	public String editarTurma(@PathVariable("matricula") String matricula,
							  Model model,
							  RedirectAttributes redirect) {
		Aluno aluno = alunoRepository.getAlunosEspecifica(matricula);
		model.addAttribute("aluno", alunoRepository.getAlunosEspecifica(matricula));
		model.addAttribute("turmas", turmaRepository.getAllTurmas());
		redirect.addFlashAttribute("msg", "Aluno(a) "+aluno.getNome()+" atualizado(a) com sucesso!");
		return "/aluno/new-aluno";
	}
}
