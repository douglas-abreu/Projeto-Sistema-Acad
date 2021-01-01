package com.ifrn.atv3douglasEvinicius.model;

public enum Papel {
	ADMIN(1), SECRETARIA(2), USER(3);
	private final int valor;
	
	Papel(int valorOpcao){
		valor = valorOpcao;
	}
	
	public int getValor(){
		return valor;
	}
}
