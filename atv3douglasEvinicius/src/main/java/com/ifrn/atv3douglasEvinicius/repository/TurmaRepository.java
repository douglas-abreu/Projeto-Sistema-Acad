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

	public void setTurmas(ArrayList<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public ArrayList<Turma> getAllTurmas(){
		System.out.println(this.turmas);
		return this.turmas;
	}

	public void save(Turma turma) {
		turmas.add(turma);
	}
}
