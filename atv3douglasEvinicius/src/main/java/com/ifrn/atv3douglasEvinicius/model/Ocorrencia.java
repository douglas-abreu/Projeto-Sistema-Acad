package com.ifrn.atv3douglasEvinicius.model;

import java.util.Calendar;

public class Ocorrencia {
	private String titulo;
	private String descricao;
	private Calendar dataHora;
	private Aluno aluno;
	private StatusOcorrencia status;
	
	public Ocorrencia() {
		super();
		
	}
	
	public void cadastrar() {
		
	}
	
	public void editar() {
		
	}
	
	public void buscarTodas() {
		
	}
	
	public Ocorrencia buscarPorAluno(Aluno aluno) {
		Ocorrencia ocorrencia = new Ocorrencia();
		return ocorrencia;
	}
	
	
}
