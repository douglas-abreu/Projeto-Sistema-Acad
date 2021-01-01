package com.ifrn.atv3douglasEvinicius.model;

public class Usuario {

	private int id;
	private String nome;
	private String email;
	private String login;
	private String senha;
	private Papel funcao;
	
	public Usuario(){
		super();
	}
	
	public Usuario(String nome, String email, String login, String senha, Papel funcao) {
		super();
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.funcao = funcao;
	}
	
	
	public Usuario(int id, String nome, String email, String login, String senha, Papel funcao) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.funcao = funcao;
	}
	
	
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Papel getFuncao() {
		return funcao;
	}
	public void setFuncao(Papel funcao) {
		this.funcao = funcao;
	}
	
	
}
