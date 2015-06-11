package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.TarefaSimples;
import model.Usuario;
import model.operacoesBD.ManipuladorBancoDados;
import model.operacoesBD.ManipuladorTarefaSimples;

public class DaoTarefaSimples extends DAO<TarefaSimples, Usuario> {
	
	ManipuladorBancoDados<TarefaSimples> mb = new ManipuladorTarefaSimples();
	
	@Override
	public ArrayList<TarefaSimples> getLista(Usuario usuario) {
		try{
			return mb.selectListaEntidadeComParametro(usuario);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public void insere(TarefaSimples tarefa, Usuario usuario) {
		mb.insereEntidade(tarefa, usuario);
	}
	
	@Override
	public void atualiza(TarefaSimples tarefa) {
		mb.atualizaEntidade(tarefa);
	}
	
	@Override
	public void delete(TarefaSimples tarefa) {
		mb.removeEntidade(tarefa);
	}
}
