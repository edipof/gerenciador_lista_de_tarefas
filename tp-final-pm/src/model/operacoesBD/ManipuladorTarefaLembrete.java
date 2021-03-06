package model.operacoesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entidade.Lembrete;
import model.entidade.Usuario;

public class ManipuladorTarefaLembrete extends ManipuladorBancoDados<Lembrete> {
	private boolean retorno = false;
	private ComandosSqlSingleton sql = getComandosSQL();
	private static ManipuladorTarefaLembrete instancia;
	
	private ManipuladorTarefaLembrete(){
	}
	
	public static synchronized ManipuladorTarefaLembrete getInstance() {
		if (instancia == null)
			instancia = new ManipuladorTarefaLembrete();
		return instancia;
	}
	
	@Override
	public ArrayList<Lembrete> selectListaEntidade() {
		return null;
	}
	
	@Override
	public ArrayList<Lembrete> selectListaEntidadeComParametro(Object object) {
		
		ArrayList<Lembrete> listaTarefas = new ArrayList<Lembrete>();
		String titulo = "";
		String descricao = "";
		String data = "";
		String hora = "";
		Usuario usuario = (Usuario) object;
		Connection con = null;
		try{
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(sql.getSELECT_TAREFA_LEMBRETE_POR_USUARIO());
			prepared.setLong(1, usuario.getId());
			ResultSet resultSet = prepared.executeQuery();
			while(resultSet.next()){
				titulo = resultSet.getString("TITULO");
				descricao = resultSet.getString("DESCRICAO");
				data = resultSet.getString("DATA");
				hora = resultSet.getString("HORA");
				Lembrete tarefa = new Lembrete(titulo, descricao, usuario, data, hora);
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
		Lembrete tarefa = (Lembrete) objects[0];
		Usuario usuario = (Usuario) objects[1];
		
		Connection con = null;
		try{
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(sql.getINSERT_TAREFA_LEMBRETE_POR_USUARIO());
			prepared.setString(1, tarefa.getTitulo());
			prepared.setString(2, tarefa.getDescricao());
			prepared.setString(3, tarefa.getData());
			prepared.setString(4, tarefa.getHora());
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
		
		Lembrete tarefa = (Lembrete) objects[0];

		Connection con = null;
		
		try{
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(sql.getUPDATE_TAREFA_LEMBRETE());
			prepared.setString(1, tarefa.getTitulo());
			prepared.setString(2, tarefa.getDescricao());
			prepared.setString(3, tarefa.getHora());
			prepared.setString(4,tarefa.getData());
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
		Lembrete tarefa = (Lembrete)objects[0];
		
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
