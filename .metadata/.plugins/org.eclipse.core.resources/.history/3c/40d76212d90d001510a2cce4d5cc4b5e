package control;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;
import control.operacoesBD.ManipuladorBancoDados;
import control.operacoesBD.ManipuladorUsuario;

public class TestaUsuario {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws SQLException {
		ManipuladorBancoDados mb = new ManipuladorUsuario();
		Usuario u1 = new Usuario();
		u1.setNome("Édipo");
		Usuario u2 = new Usuario();
		u2.setNome("Diego");
		Usuario u3 = new Usuario();
		u3.setNome("Bruno");
		Usuario u4 = new Usuario();
		u4.setNome("Barsand");
/*		
		mb.insereEntidade(u1);
		mb.insereEntidade(u2);
		mb.insereEntidade(u3);
		mb.insereEntidade(u4);
*/		
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios =  mb.selectListaEntidade();

		for (Usuario usuario : listaUsuarios) {
			System.out.println(usuario.getId() + " " + usuario.getNome());
			if(usuario.getNome().equals(u1.getNome()))
				u1 = usuario;
		}

/*
		u1.setNome("Édipo o/");
		mb.atualizaEntidade(u1);
		
		Usuario uRemove = new Usuario();
		uRemove.setNome("remove");
		mb.insereEntidade(uRemove);
		
		listaUsuarios =  mb.selectListaEntidade();
		for (Usuario usuario : listaUsuarios) {
			System.out.println(usuario.getId() + " " + usuario.getNome());
			if(usuario.getNome().equals("remove"))
				mb.removeEntidade(usuario);
		}
*/		

	}

}
