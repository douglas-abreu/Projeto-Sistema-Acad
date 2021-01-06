package com.ifrn.atv3douglasEvinicius.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ifrn.atv3douglasEvinicius.model.Aluno;
import com.ifrn.atv3douglasEvinicius.repository.AlunoRespository;

@RestController
public class AlunoResource {

	@Autowired
	private AlunoRespository repository;
	
	@GetMapping("/api/aluno")
	public ArrayList<Aluno> getAlunos(){
		return repository.getAllAlunos();
	}
	
	@GetMapping("/api/aluno/{matricula}")
	public ResponseEntity<Aluno> getAlunosByMatricula(@PathVariable("matricula") String matricula){
		Aluno aluno = repository.getAlunosEspecifica(matricula);
		if(aluno != null) {
			return ResponseEntity.ok(aluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/api/aluno")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Aluno createAluno(@RequestBody Aluno aluno) {
		repository.save(aluno);
		return aluno;
	}

	@PutMapping("api/aluno/{matricula}")
	public ResponseEntity<Aluno> updateAluno(@PathVariable("matricula") String matricula,
											 @RequestBody Aluno aluno){
		Aluno a = repository.getAlunosEspecifica(matricula);
		if(a != null) {
			repository.atualizar(aluno);
			return ResponseEntity.ok(aluno);
		}else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@DeleteMapping("/api/aluno/{matricula}")
	public ResponseEntity<Aluno> deleteAluno(@PathVariable("matricula") String matricula){
		Aluno a = repository.getAlunosEspecifica(matricula);
		if(a != null) {
			repository.delete(a);
			return ResponseEntity.ok(a);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
}
