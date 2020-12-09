package com.ifrn.atv3douglasEvinicius.model;

import java.util.ArrayList;

public class Turma {
	private String nome;
	private String codigo;
	private int ano;
	private int periodo;
	private ArrayList<Aluno> aluno;
	
	public Turma() {
		super();
	}

	public Turma(String nome, String codigo, int ano, int periodo) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.ano = ano;
		this.periodo = periodo;
		//this.aluno = aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public ArrayList<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(ArrayList<Aluno> aluno) {
		this.aluno = aluno;
	}
}
