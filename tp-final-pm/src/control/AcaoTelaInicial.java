package control;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;
import model.operacoesBD.ManipuladorBancoDados;
import model.operacoesBD.ManipuladorUsuario;

public class AcaoTelaInicial {
	
	public ArrayList<Usuario> buscarListaUsuarios() throws SQLException{
		
		ManipuladorBancoDados<Usuario> mdb = new ManipuladorUsuario();
		return mdb.selectListaEntidade();
	}
	
	public void adicionaNovoUsuario(String nome){
		
		ManipuladorBancoDados<Usuario> mdb = new ManipuladorUsuario();
		Usuario u = new Usuario();
		u.setNome(nome);
		mdb.insereEntidade(u);
		
	}
}
