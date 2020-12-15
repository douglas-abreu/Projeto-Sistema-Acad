package com.ifrn.atv3douglasEvinicius.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ifrn.atv3douglasEvinicius.model.Aluno;
import com.ifrn.atv3douglasEvinicius.model.Turma;

@Repository
public class AlunoRespository {
	private ArrayList<Aluno> listaAlunos;
	
	public AlunoRespository() {
		TurmaRepository turmaRepository = new TurmaRepository();
		listaAlunos = new ArrayList<Aluno>();
		
		listaAlunos.add(new Aluno("20191","Junim", 2000, "1111-1111", "junim@gmail.com", turmaRepository.getTurmas().get(0)));
		listaAlunos.add(new Aluno("20191","Pedim", 2001, "1111-2222", "pedim@gmail.com", turmaRepository.getTurmas().get(0)));
		listaAlunos.add(new Aluno("20191","Paulim", 2001, "1111-3333", "paulim@gmail.com", turmaRepository.getTurmas().get(0)));
		listaAlunos.add(new Aluno("20191","Teteu", 1999, "1111-44444", "teteu@gmail.com", turmaRepository.getTurmas().get(1)));
		listaAlunos.add(new Aluno("20191","Brunim", 1998, "1111-5555", "brunim@gmail.com", turmaRepository.getTurmas().get(1)));
		listaAlunos.add(new Aluno("20191","Manuelim", 2002, "1111-6666", "manuelim@gmail.com", turmaRepository.getTurmas().get(1)));
		listaAlunos.add(new Aluno("20191","Joãozim", 2002, "1111-7777", "joaozim@gmail.com", turmaRepository.getTurmas().get(2)));
		listaAlunos.add(new Aluno("20191","Humbertim", 2001, "1111-8888", "humbertim@gmail.com", turmaRepository.getTurmas().get(2)));
		listaAlunos.add(new Aluno("20191","Francisquim", 2000, "1111-9999", "francisquim@gmail.com", turmaRepository.getTurmas().get(2)));
		listaAlunos.add(new Aluno("20191","Antonim", 2001, "2222-2222", "antonim@gmail.com", turmaRepository.getTurmas().get(3)));
		listaAlunos.add(new Aluno("20191","Karlinha", 2003, "2222-3333", "karlinha@gmail.com", turmaRepository.getTurmas().get(3)));
		listaAlunos.add(new Aluno("20191","Mariazinha", 2002, "2222-4444", "mariazinha@gmail.com", turmaRepository.getTurmas().get(3)));
	}
	
	public ArrayList<Aluno> getAllAlunos(){
		return this.listaAlunos;
	}

	public ArrayList<Aluno> getAlunosTurma(String codigoTurma) {
		ArrayList<Aluno> listaDetalhada = new ArrayList<Aluno>();
		for (Aluno aluno : listaAlunos) {
			if(aluno.getTurma().getCodigo().equalsIgnoreCase(codigoTurma)) {
				listaDetalhada.add(aluno);
			}
		}
		return listaDetalhada;
	}
	
	public Aluno getAlunosEspecifica(String nomeAluno) {
		for (Aluno aluno : listaAlunos) {
			if(aluno.getNome().equalsIgnoreCase(nomeAluno)) {
				System.out.println("Aluno encontrada");
				return aluno;
			}
		}
		System.out.println("turma não encontrada");
		return null;
	}
	
	
	public void save(Aluno aluno) {
		listaAlunos.add(aluno);
	}
}
