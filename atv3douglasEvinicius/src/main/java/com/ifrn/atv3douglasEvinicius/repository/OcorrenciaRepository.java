package com.ifrn.atv3douglasEvinicius.repository;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ifrn.atv3douglasEvinicius.model.Aluno;
import com.ifrn.atv3douglasEvinicius.model.Ocorrencia;
import com.ifrn.atv3douglasEvinicius.model.StatusOcorrencia;

@Repository
public class OcorrenciaRepository {
private ArrayList<Ocorrencia> listaOcorrencias;
private ArrayList<Ocorrencia> ocorrenciaStatus;
private Calendar c;	
int count = 31;

	public OcorrenciaRepository() {
		AlunoRespository alunoRepository = new AlunoRespository();
		listaOcorrencias = new ArrayList<Ocorrencia>();
		Calendar c = Calendar.getInstance();
		c.set(2020, 11, 20, 14, 35);
		listaOcorrencias.add(new Ocorrencia(10,"AGRESSAO FISICA","Aluno agrediu colega",c.getTime(),alunoRepository.getAllAlunos().get(0),StatusOcorrencia.ANALISE));
		c.set(2020, 11, 20, 14, 35);
		listaOcorrencias.add(new Ocorrencia(5,"BIXO É O CÃO","Aluno destruiu o armário",c.getTime(),alunoRepository.getAllAlunos().get(0),StatusOcorrencia.RESOLVIDA));
		c.set(2020, 2, 3, 12, 38);
		listaOcorrencias.add(new Ocorrencia(6,"AGRESSAO VERBAL","Aluno agrediu professor",c.getTime(),alunoRepository.getAllAlunos().get(2),StatusOcorrencia.CADASTRADA));
		c.set(2020, 04, 10, 10, 21);
		listaOcorrencias.add(new Ocorrencia(23,"JUSTIFICATIVA FALTA","Aluno justifica falta do dia 10.05.2020",c.getTime(),alunoRepository.getAllAlunos().get(1),StatusOcorrencia.RESOLVIDA));
		c.set(2019, 01, 16, 11, 13);
		listaOcorrencias.add(new Ocorrencia(31,"ATRASO","Aluno chegou faltando apenas 5min para o fim da aula",c.getTime(),alunoRepository.getAllAlunos().get(5),StatusOcorrencia.CANCELADA));
	}
	

	public StatusOcorrencia[] getAllOcorrenciaStatus(){
		System.out.println(StatusOcorrencia.values());
		return StatusOcorrencia.values();
		
	}
	
	public ArrayList<Ocorrencia> getAllOcorrencias(){
		return listaOcorrencias;
	}
	
	public ArrayList<Ocorrencia> getOcorrenciaPerAluno(String nomeOcorrencia) {
		ArrayList<Ocorrencia> listaDetalhada = new ArrayList<Ocorrencia>();
		for (Ocorrencia ocorr : listaOcorrencias) {
			if(ocorr.getAluno().getNome().equalsIgnoreCase(nomeOcorrencia)) {
				listaDetalhada.add(ocorr);
			}
		}
		return listaDetalhada;
	}
	
	
	
	
	

	public void save(Ocorrencia ocorr) {
		count = count + 1;
		ocorr.setId(count);
		listaOcorrencias.add(ocorr);

	}
	
}
