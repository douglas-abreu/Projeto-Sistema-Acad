package com.ifrn.atv3douglasEvinicius.model;

public enum StatusOcorrencia {
	CADASTRADA(1), ANALISE(2), CANCELADA(3), RESOLVIDA(4);
	private final int valor;
	
	StatusOcorrencia(int valorOpcao){
		valor = valorOpcao;
	}
	
	public int getValor(){
		return valor;
	}
}
