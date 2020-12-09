package com.ifrn.atv3douglasEvinicius.model;

import java.util.ArrayList;

public class Aluno {
	private String matricula;
	private String nome;
	private int anoNascimento;
	private String telefone;
	private String email;
	private Turma turma;
	//private ArrayList<Ocorrencia> ocorrencia;
	
	public Aluno() {
		super();
	}

	public Aluno(String matricula, String nome, int anoNascimento, String telefone, String email, Turma turma) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.anoNascimento = anoNascimento;
		this.telefone = telefone;
		this.email = email;
		this.turma = turma;
		//this.ocorrencia = ocorrencia;
	}



	public void cadastrar() {
		
	}
	
	public Aluno remover(Aluno aluno) {
		return aluno;
	}
	
	public void editar(Aluno aluno) {
		
	}
	
	public ArrayList<Aluno> buscarTodos() {
		ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
		return listaAlunos;
	}
}
