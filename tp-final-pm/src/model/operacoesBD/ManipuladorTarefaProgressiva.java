package model.operacoesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entidade.TarefaProgressiva;
import model.entidade.Usuario;

public class ManipuladorTarefaProgressiva extends ManipuladorBancoDados<TarefaProgressiva> {
	private boolean retorno = false;
	private ComandosSqlSingleton sql = getComandosSQL();
	
	private static ManipuladorTarefaProgressiva instancia;
	
	private ManipuladorTarefaProgressiva(){
	}
	
	public static synchronized ManipuladorTarefaProgressiva getInstance() {
		if (instancia == null)
			instancia = new ManipuladorTarefaProgressiva();
		return instancia;
	}
	
	@Override
	public ArrayList<TarefaProgressiva> selectListaEntidade() {
		return null;
	}
	
	@Override
	public ArrayList<TarefaProgressiva> selectListaEntidadeComParametro(Object object) {
		
		ArrayList<TarefaProgressiva> listaTarefas = new ArrayList<TarefaProgressiva>();
		String titulo = "";
		String descricao = "";
		String data = "";
		Long progresso = null;
		Usuario usuario = (Usuario) object;
		Connection con = null;
		try{
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(sql.getSELECT_TAREFA_PROGRESSIVA_POR_USUARIO());
			prepared.setLong(1, usuario.getId());
			prepared.setLong(2, usuario.getId());
			ResultSet resultSet = prepared.executeQuery();
			while(resultSet.next()){
				titulo = resultSet.getString("TITULO");
				descricao = resultSet.getString("DESCRICAO");
				data = resultSet.getString("DATA");
				progresso = resultSet.getLong("PROGRESSO");
				TarefaProgressiva tarefa = new TarefaProgressiva(titulo, descricao, usuario, data, progresso);
				tarefa.setId(resultSet.getLong("ID"));
				listaTarefas.add(tarefa);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnnection(con);
		}
		return listaTarefas;
	}
	
	@Override
	public Boolean insereEntidade(Object... objects){
		TarefaProgressiva  tarefa = (TarefaProgressiva) objects[0];
		Usuario usuario = (Usuario) objects[1];
		
		Connection con = null;
		try{
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(sql.getINSERT_TAREFA_PROGRESSIVA_POR_USUARIO());
			prepared.setString(1, tarefa.getTitulo());
			prepared.setString(2, tarefa.getDescricao());
			prepared.setString(3, tarefa.getData());
			prepared.setLong(4, tarefa.getProgresso());
			prepared.setLong(5, usuario.getId());
			retorno = prepared.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnnection(con);
		}
		return retorno;
	}
	
	@Override
	public void atualizaEntidade(Object... objects){
		
		TarefaProgressiva tarefa = (TarefaProgressiva) objects[0];

		Connection con = null;
		
		try{
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(sql.getUPDATE_TAREFA_PROGRESSIVA());
			prepared.setString(1, tarefa.getTitulo());
			prepared.setString(2, tarefa.getDescricao());
			prepared.setString(3, tarefa.getData());
			prepared.setLong(4,tarefa.getProgresso());
			prepared.setLong(5, tarefa.getId());
			prepared.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnnection(con);
		}
	}
	
	@Override
	public Boolean removeEntidade(Object... objects){
		TarefaProgressiva tarefa = (TarefaProgressiva)objects[0];
		
		Connection con = null;
		
		try{
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(sql.getDELETE_TAREFA());
			prepared.setLong(1, tarefa.getId());
			prepared.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnnection(con);
		}
		
		return retorno;
	}

}
