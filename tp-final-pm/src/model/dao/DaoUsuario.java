package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Tarefa;
import model.Usuario;
import model.operacoesBD.ManipuladorBancoDados;
import model.operacoesBD.ManipuladorUsuario;

public class DaoUsuario extends DAO<Usuario, Tarefa> {
	
    ManipuladorBancoDados<Usuario> mb = new ManipuladorUsuario();
	@Override
	public ArrayList<Usuario> getLista() {
		try{
			return mb.selectListaEntidade();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void insere(Usuario usuario) {
		mb.insereEntidade(usuario);
	}
	
	@Override
	public void atualiza(Usuario usuario) {
		mb.atualizaEntidade(usuario);
	}
	
	@Override
	public void delete(Usuario usuario) {
		mb.removeEntidade(usuario);
	}
}
