package control.operacoesBD;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;

public class ManipuladorUsuario extends ManipuladorBancoDados {

	private boolean retorno = false;
	private ComandosSqlSingleton sql = getComandosSQL();
	
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