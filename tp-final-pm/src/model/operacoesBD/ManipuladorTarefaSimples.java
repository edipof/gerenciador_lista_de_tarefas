package model.operacoesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entidade.TarefaSimples;
import model.entidade.Usuario;

public class ManipuladorTarefaSimples extends ManipuladorBancoDados<TarefaSimples>{
	private boolean retorno = false;
	private ComandosSqlSingleton sql = getComandosSQL();
	
	private static ManipuladorTarefaSimples instancia;
	
	private ManipuladorTarefaSimples(){
	}
	
	public static synchronized ManipuladorTarefaSimples getInstance() {
		if (instancia == null)
			instancia = new ManipuladorTarefaSimples();
		return instancia;
	}
	@Override
	public ArrayList<TarefaSimples> selectListaEntidade() {
		return null;
	}
	
	@Override
	public ArrayList<TarefaSimples> selectListaEntidadeComParametro(Object object) {
		
		ArrayList<TarefaSimples> listaTarefas = new ArrayList<TarefaSimples>();
		String titulo = "";
		String descricao = "";
		Usuario usuario = (Usuario) object;
		Connection con = null;
		try{
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(sql.getSELECT_TAREFA_SIMPLES_POR_USUARIO());
			prepared.setLong(1, usuario.getId());
			ResultSet resultSet = prepared.executeQuery();
			while(resultSet.next()){
				titulo = resultSet.getString("TITULO");
				descricao = resultSet.getString("DESCRICAO");
				TarefaSimples tarefa = new TarefaSimples(titulo, descricao, usuario);
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
		TarefaSimples tarefa = (TarefaSimples) objects[0];
		Usuario usuario = (Usuario) objects[1];
		
		Connection con = null;
		try{
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(sql.getINSERT_TAREFA_SIMPLES_POR_USUARIO());
			prepared.setString(1, tarefa.getTitulo());
			prepared.setString(2, tarefa.getDescricao());
			prepared.setLong(3, usuario.getId());
			
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
		
		TarefaSimples tarefa = (TarefaSimples) objects[0];

		Connection con = null;
		
		try{
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(sql.getUPDATE_TAREFA_SIMPLES());
			prepared.setString(1, tarefa.getTitulo());
			prepared.setString(2, tarefa.getDescricao());
			prepared.setLong(3, tarefa.getId());
			prepared.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnnection(con);
		}
	}
	
	@Override
	public Boolean removeEntidade(Object... objects){
		TarefaSimples tarefa = (TarefaSimples)objects[0];
		
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
