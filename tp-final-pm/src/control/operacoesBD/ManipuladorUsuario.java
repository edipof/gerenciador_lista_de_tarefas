package control.operacoesBD;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;

public class ManipuladorUsuario {
	
	private ManipuladorBancoDados conexao = new ManipuladorBancoDados();
	private ComandosSqlSingleton sql = ComandosSqlSingleton.getInstance();
	private boolean retorno = false;
	
	public Usuario selectUsuario() throws SQLException{
		//TODO
		return null;
	}
	
	public ArrayList<Usuario> selectListaUsuarios(){
		//TODO
		return null;
	}
	
	public Boolean insereUsuario(){
		//TODO
		return retorno;
	}
	
	public Boolean atualizaUsuario(){
		//TODO
		return retorno;
	}
	
	public Boolean removeUsuario(){
		//TODO
		return retorno;
	}
}
