package com.ifrn.atv3douglasEvinicius.model;


import java.util.Calendar;
import java.util.Date;

public class Ocorrencia {
	private String titulo;
	private String descricao;
	private Date dataHora;
	private Aluno aluno;
	private StatusOcorrencia status;
	
	public Ocorrencia() {
		super();
		
	}
	
	public Ocorrencia(String titulo, String descricao, StatusOcorrencia status) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
	}
	

	
	public Ocorrencia(String titulo, String descricao, Date dataHora, Aluno aluno, StatusOcorrencia status) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataHora = dataHora;
		this.aluno = aluno;
		this.status = status;
	}

	


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date calendar) {
		this.dataHora = calendar;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public StatusOcorrencia getStatus() {
		return status;
	}

	public void setStatus(StatusOcorrencia status) {
		this.status = status;
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
