package control.operacoesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TarefaSimples;
import model.Usuario;

public class ManipuladorTarefaSimples extends ManipuladorBancoDados{
	private boolean retorno = false;
	private ComandosSqlSingleton sql = getComandosSQL();
	
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
//				usuario.setId(resultSet.getLong("USUARIO_ID"));
//				usuario.setNome(resultSet.getString("NOME"));
				//listaTarefas.add(usuario);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnnection(con);
		}
		return listaTarefas;
	}
	@Override
	public Boolean insereEntidade(Object object){
		Usuario usuario = (Usuario) object;
		Connection con = null;
		try{
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(sql.getINSERT_USUARIO());
			prepared.setString(1, usuario.getNome());
			retorno = prepared.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnnection(con);
		}
		return retorno;
	}
	@Override
	public void atualizaEntidade(Object object){
		Usuario usuario = (Usuario) object;
		Connection con = null;
		
		try{
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(sql.getUPDATE_USUARIO());
			prepared.setString(1, usuario.getNome());
			prepared.setLong(2, usuario.getId());
			prepared.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnnection(con);
		}
	}
	@Override
	public Boolean removeEntidade(Object object){
		Usuario usuario = (Usuario) object;
		Connection con = null;
		
		try{
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(sql.getDELETE_USUARIO());
			prepared.setLong(1, usuario.getId());
			prepared.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnnection(con);
		}
		
		return retorno;
	}
}