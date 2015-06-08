package control;

import java.sql.SQLException;
import java.util.ArrayList;

import model.TarefaSimples;
import model.Usuario;
import control.operacoesBD.ManipuladorBancoDados;
import control.operacoesBD.ManipuladorTarefaSimples;
import control.operacoesBD.ManipuladorUsuario;

public class TestaTarefas {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws SQLException {
		ManipuladorBancoDados usuarioDTO = new ManipuladorUsuario();
		ManipuladorBancoDados tarefaDTO = new ManipuladorTarefaSimples();
		
		Usuario usuario1 = (Usuario) usuarioDTO.selectListaEntidade().get(0);
		/*Usuario usuario2 = (Usuario) usuarioDTO.selectListaEntidade().get(1);
		String titulo = "Teste Tarefa Simples 3";
		String descricao = "Teste descricao tarefa simples! 3";
		//insere
		
		TarefaSimples tarefaSimples = new TarefaSimples(titulo, descricao, usuario1);
		tarefaDTO.insereEntidade(tarefaSimples, usuario1);
		*/
		//select
		ArrayList<TarefaSimples> listaTarefaSimples = new ArrayList<TarefaSimples>();
		listaTarefaSimples = tarefaDTO.selectListaEntidadeComParametro(usuario1);
		
		TarefaSimples t1 = null;
		
		for (TarefaSimples tarefa : listaTarefaSimples) {
			System.out.println(tarefa.getTitulo()+ " " + tarefa.getDescricao() + " " + tarefa.getUsuario().getNome());
			if(tarefa.getId() == 1)
				t1 = tarefa;
				
		}
		//update
		if(t1 != null){
			t1.setTitulo("UPDATE teste");
			tarefaDTO.atualizaEntidade(t1);
		}
	
		
		listaTarefaSimples = tarefaDTO.selectListaEntidadeComParametro(usuario1);
		
		for (TarefaSimples tarefa : listaTarefaSimples) {
			System.out.println(tarefa.getTitulo()+ " " + tarefa.getDescricao() + " " + tarefa.getUsuario().getNome());
			if(tarefa.getId() == 1)
				t1 = tarefa;
				
		}
		//remove
		if(t1 != null)
			tarefaDTO.removeEntidade(t1);
		listaTarefaSimples = tarefaDTO.selectListaEntidadeComParametro(usuario1);
		for (TarefaSimples tarefa : listaTarefaSimples) {
			System.out.println(tarefa.getTitulo()+ " " + tarefa.getDescricao() + " " + tarefa.getUsuario().getNome());
		}
	}

}
