package com.ifrn.atv3douglasEvinicius.repository;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.ifrn.atv3douglasEvinicius.model.Turma;

@Repository
public class TurmaRepository {
	private ArrayList<Turma> turmas;

	public TurmaRepository() {
		turmas = new ArrayList<Turma>();
		turmas.add(new Turma("TSI", "1", 2019, 1));
		turmas.add(new Turma("MECA", "2", 2019, 1));
		turmas.add(new Turma("REDES", "3", 2019, 1));
		turmas.add(new Turma("INFO", "4", 2019, 1));		
	}

	public ArrayList<Turma> getTurmas() {
		return turmas;
	}
	
	public Turma getTurmasEspecifica(String nomeTurma) {
		for (Turma turma : turmas) {
			if(turma.getNome().equalsIgnoreCase(nomeTurma)) {
				System.out.println("turma encontrada");
				return turma;
			}
		}
		System.out.println("turma não encontrada");
		return null;
	}

	public void setTurmas(ArrayList<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public ArrayList<Turma> getAllTurmas(){
		return this.turmas;
	}

	public void save(Turma turma) {
		turmas.add(turma);
	}
}
