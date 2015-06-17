package control;

import java.sql.SQLException;
import java.util.ArrayList;

import model.entidade.Usuario;
import model.operacoesBD.ManipuladorBancoDados;
import model.operacoesBD.ManipuladorUsuario;

public class AcaoTelaInicial {
	
	ManipuladorBancoDados<Usuario> mdb = new ManipuladorUsuario();
	
	public ArrayList<Usuario> buscarListaUsuarios() throws SQLException{
		
		return mdb.selectListaEntidade();
	}
	
	public void adicionaNovoUsuario(String nome){
		
		Usuario u = new Usuario();
		u.setNome(nome);
		mdb.insereEntidade(u);
	}
	
	public boolean removeUsuario(Usuario user) {

		return mdb.removeEntidade(user);		
	}
	
	public Usuario buscaUmUsuario(String user){
		
		ArrayList<Usuario> listaUsuario = null;
		Usuario aux = null;
		try {
			listaUsuario = mdb.selectListaEntidade();
		} catch (SQLException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}
		for (Usuario usuario : listaUsuario) {
			
			if (usuario.getNome().equals(user)){
				aux = usuario;
			} 
		}
		return aux;
	}
}
