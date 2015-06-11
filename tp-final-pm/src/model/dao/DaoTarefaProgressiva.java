package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.TarefaProgressiva;
import model.Usuario;
import model.operacoesBD.ManipuladorBancoDados;
import model.operacoesBD.ManipuladorTarefaProgressiva;

public class DaoTarefaProgressiva extends DAO<TarefaProgressiva, Usuario> {
	
	ManipuladorBancoDados<TarefaProgressiva> mb = new ManipuladorTarefaProgressiva();
	
	@Override
	public ArrayList<TarefaProgressiva> getLista(Usuario usuario) {
		try{
			return mb.selectListaEntidadeComParametro(usuario);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public void insere(TarefaProgressiva tarefa, Usuario usuario) {
		mb.insereEntidade(tarefa, usuario);
	}
	
	@Override
	public void atualiza(TarefaProgressiva tarefa) {
		mb.atualizaEntidade(tarefa);
	}
	
	@Override
	public void delete(TarefaProgressiva tarefa) {
		mb.removeEntidade(tarefa);
	}
}
