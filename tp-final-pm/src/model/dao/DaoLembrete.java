package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Lembrete;
import model.Usuario;
import model.operacoesBD.ManipuladorBancoDados;
import model.operacoesBD.ManipuladorTarefaLembrete;

public class DaoLembrete extends DAO<Lembrete, Usuario> {
ManipuladorBancoDados<Lembrete> mb = new ManipuladorTarefaLembrete();
	
	@Override
	public ArrayList<Lembrete> getLista(Usuario usuario) {
		try{
			return mb.selectListaEntidadeComParametro(usuario);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public void insere(Lembrete tarefa, Usuario usuario) {
		mb.insereEntidade(tarefa, usuario);
	}
	
	@Override
	public void atualiza(Lembrete tarefa) {
		mb.atualizaEntidade(tarefa);
	}
	
	@Override
	public void delete(Lembrete tarefa) {
		mb.removeEntidade(tarefa);
	}
}