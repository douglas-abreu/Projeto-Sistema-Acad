package com.ifrn.atv3douglasEvinicius.repository;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import com.ifrn.atv3douglasEvinicius.model.Papel;
import com.ifrn.atv3douglasEvinicius.model.StatusOcorrencia;
import com.ifrn.atv3douglasEvinicius.model.Usuario;


@Repository
public class UsuarioRepository {
	private ArrayList<Usuario> users;
	int count = 2;
	public UsuarioRepository(){
		users = new ArrayList<Usuario>();
		users.add(new Usuario(1,"Vinicius","vinicius@admin.com","vric4rdo","ts2020",Papel.ADMIN));
		users.add(new Usuario(2,"Nath","nath@secre.com","nath72","ts2020", Papel.SECRETARIA));
	}

	public ArrayList<Usuario> getAllUsers(){
		return users;
	}
	
	public Usuario verificar(String login, String senha) {
		Usuario userLocal = null;
		for (Usuario usuario : users) {
			if(usuario.getLogin().equals(login) &&
			   usuario.getSenha().equals(senha)) {
				userLocal = usuario;
				return userLocal;
			}
		}
		return userLocal;
	}

	public void save(Usuario user) {
	    count = count + 1;
		user.setId(count);
		users.add(user);

	}

	public Papel[] getAllFuncao(){
		System.out.println(Papel.values());
		return Papel.values();
		
	}
	
}
