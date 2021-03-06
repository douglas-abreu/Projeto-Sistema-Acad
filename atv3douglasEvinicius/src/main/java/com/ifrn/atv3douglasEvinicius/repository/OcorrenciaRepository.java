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
		listaOcorrencias.add(new Ocorrencia(5,"BIXO � O C�O","Aluno destruiu o arm�rio",c.getTime(),alunoRepository.getAllAlunos().get(0),StatusOcorrencia.RESOLVIDA));
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
	
	public ArrayList<Ocorrencia> getOcorrenciaPerAluno(String matricula) {
		ArrayList<Ocorrencia> listaDetalhada = new ArrayList<Ocorrencia>();
		for (Ocorrencia ocorr : listaOcorrencias) {
			if(ocorr.getAluno().getMatricula().equalsIgnoreCase(matricula)) {
				listaDetalhada.add(ocorr);
			}
		}
		return listaDetalhada;
	}

	public Ocorrencia getOcorrenciaEspecifica(int id) {
		for(Ocorrencia ocorr : listaOcorrencias) {
			if(ocorr.getId() == id) {
				return ocorr;
			}
		}
		return null;
	}
	
	public void save(Ocorrencia ocorr) {
		count = count + 1;
		ocorr.setId(count);
		listaOcorrencias.add(ocorr);

	}
	
	public void atualizar(Ocorrencia ocorr) {
		Ocorrencia novaOcorr = getOcorrenciaEspecifica(ocorr.getId());
		novaOcorr.setTitulo(ocorr.getTitulo());
		System.out.println(ocorr.getTitulo());
		novaOcorr.setDescricao(ocorr.getDescricao());
		System.out.println(ocorr.getDescricao());
		novaOcorr.setAluno(ocorr.getAluno());
		System.out.println(ocorr.getAluno());
		novaOcorr.setStatus(ocorr.getStatus());
		System.out.println(ocorr.getStatus());
		novaOcorr.setId(ocorr.getId());
		System.out.println(ocorr.getId());
		

	}
	
	/*=================================== M�TODOS API ===============================*/
	public void delete(Ocorrencia ocorr) {
		listaOcorrencias.remove(ocorr);
	}
}
