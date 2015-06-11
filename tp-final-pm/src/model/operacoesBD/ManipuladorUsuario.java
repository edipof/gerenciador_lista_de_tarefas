package model.operacoesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;

public class ManipuladorUsuario extends ManipuladorBancoDados {

	private boolean retorno = false;
	private ComandosSqlSingleton sql = getComandosSQL();
	
	@Override
	public ArrayList<Usuario> selectListaEntidadeComParametro(Object o){
		//nao tem necessidade de implementar esse metodo no momento
		return null;
	}
	
	@Override
	public ArrayList<Usuario> selectListaEntidade() {
		
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Connection con = null;
		try{
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(sql.getSELECT_USUARIO());
			ResultSet resultSet = prepared.executeQuery();
			while(resultSet.next()){
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getLong("ID"));
				usuario.setNome(resultSet.getString("NOME"));
				listaUsuarios.add(usuario);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnnection(con);
		}
		return listaUsuarios;
	}
	@Override
	public Boolean insereEntidade(Object... objects){
		Usuario usuario = null;
		
		for(Object object : objects){
			if(objects.length == 1)
				usuario = (Usuario) object;
		}
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
	public void atualizaEntidade(Object... objects){
		Usuario usuario = null;
		
		for(Object object : objects){
			if(objects.length == 1)
				usuario = (Usuario) object;
		}
		
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
	public Boolean removeEntidade(Object... objects){
		Usuario usuario = null;
		
		for(Object object : objects){
			if(objects.length == 1)
				usuario = (Usuario) object;
		}
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
