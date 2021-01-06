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

import com.ifrn.atv3douglasEvinicius.model.Turma;
import com.ifrn.atv3douglasEvinicius.repository.TurmaRepository;

@RestController
public class TurmaResource {
	
	@Autowired
	private TurmaRepository repository;
	
	@GetMapping("/api/turma")
	public ArrayList<Turma> getTurmas(){
		return repository.getApiTurmas();
	}

	@GetMapping("/api/turma/{codigo}")
	public ResponseEntity<Turma> getTurmasByCodigo(@PathVariable("codigo") String codigo){
		Turma turma = repository.getTurmasEspecifica(codigo);
		if(turma != null) {
			return ResponseEntity.ok(turma);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/api/turma")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Turma createTurma(@RequestBody Turma turma) {
		repository.save(turma);
		return turma;
	}

	@PutMapping("api/turma/{codigo}")
	public ResponseEntity<Turma> updateTurma(@PathVariable("codigo") String codigo,
							 @RequestBody Turma turma) {
		Turma t = repository.getTurmasEspecifica(codigo);
		if(t != null) {
			repository.atualizar(turma);
			return ResponseEntity.ok(turma);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("api/turma/{codigo}")
	public ResponseEntity<Turma> deleteTurma(@PathVariable("codigo") String codigo) {
		Turma t =  repository.getTurmasEspecifica(codigo);
		if(t != null) {
			repository.deleteTurma(codigo);
			return ResponseEntity.ok(t);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
