package com.ifrn.atv3douglasEvinicius.model;

import java.util.ArrayList;

public class Aluno {
	private String matricula;
	private String nome;
	private int anoNascimento;
	private String telefone;
	private String email;
	private Turma turma;
	private ArrayList<Ocorrencia> ocorrencia;
	
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
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public ArrayList<Ocorrencia> getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(ArrayList<Ocorrencia> ocorrencia) {
		this.ocorrencia = ocorrencia;
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
