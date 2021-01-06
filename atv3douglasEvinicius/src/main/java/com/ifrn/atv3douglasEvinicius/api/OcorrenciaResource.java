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

import com.ifrn.atv3douglasEvinicius.model.Ocorrencia;
import com.ifrn.atv3douglasEvinicius.repository.OcorrenciaRepository;

@RestController
public class OcorrenciaResource {

	@Autowired
	private OcorrenciaRepository repository;
	
	@GetMapping("/api/ocorrencia")
	public ArrayList<Ocorrencia> getOcorrencias(){
		return repository.getAllOcorrencias();
	}
	
	@GetMapping("/api/ocorrencia/{id}")
	public ResponseEntity<Ocorrencia> getOcorrenciasById(@PathVariable("id") int id){
		Ocorrencia o = repository.getOcorrenciaEspecifica(id);
		if(o != null) {
			return ResponseEntity.ok(o);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping("/api/ocorrencia")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ocorrencia createOcorrencia(@RequestBody Ocorrencia ocorrencia) {
		repository.save(ocorrencia);
		return ocorrencia;
	}
	
	@PutMapping("/api/ocorrencia/{id}")
	public ResponseEntity<Ocorrencia> updateOcorrencia(@PathVariable("id") int id,
													   @RequestBody Ocorrencia ocorrencia){
		Ocorrencia o = repository.getOcorrenciaEspecifica(id);
		if(o != null) {
			repository.atualizar(ocorrencia);
			return ResponseEntity.ok(ocorrencia);
		} else {
			return ResponseEntity.notFound().build();
		}	
		
	}
	
	@DeleteMapping("api/ocorrencia/{id}")
	public ResponseEntity<Ocorrencia> deleteOcorrencia(@PathVariable("id") int id){
		Ocorrencia o = repository.getOcorrenciaEspecifica(id);
		if(o != null) {
			repository.delete(o);
			return ResponseEntity.ok(o);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
}
