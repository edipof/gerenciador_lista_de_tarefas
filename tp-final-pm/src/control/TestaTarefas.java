package control;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Lembrete;
import model.Tarefa;
import model.TarefaSimples;
import model.Usuario;
import model.dao.DAO;
import model.dao.DaoLembrete;
import model.dao.DaoTarefaSimples;
import model.dao.DaoUsuario;

public class TestaTarefas {
	
	public static void main(String[] args) throws SQLException {
		DAO<Usuario,Tarefa> usuarioDTO = new DaoUsuario();
		DAO<TarefaSimples,Usuario> tarefaDTO = new DaoTarefaSimples();
		DAO<Lembrete,Usuario> lembreteDTO = new DaoLembrete();
		
		Usuario usuario1 = (Usuario) usuarioDTO.getLista().get(0);
		Usuario usuario2 = (Usuario) usuarioDTO.getLista().get(1);
		
		//insere
		String titulo = "Tarefa Simples | ";
		String descricao = "Descricao Lembrete |";
		TarefaSimples tarefaSimples = new TarefaSimples(titulo, descricao, usuario1);
		tarefaDTO.insere(tarefaSimples, usuario1);
		
		//select
		ArrayList<TarefaSimples> listaTarefaSimples = new ArrayList<TarefaSimples>();
		listaTarefaSimples = tarefaDTO.getLista(usuario1);
		
		for (TarefaSimples tarefa : listaTarefaSimples) {
			System.out.println(tarefa.getTitulo()+ " " + tarefa.getDescricao() + " " + tarefa.getUsuario().getNome());
		}
		
		String tituloL = "Lembrete | ";
		String descricaoL = "Descricao Lembrete |";
		String data = "08/06/2015";
		String hora = "09:18";
		/**/
		//criando lembrete
		Lembrete lembrete = new Lembrete(tituloL, descricaoL, usuario1, data, hora);
		//inserindo lembrete
		lembreteDTO.insere(lembrete, usuario1);
		
		//select
		ArrayList<Lembrete> listaLembrete = new ArrayList<Lembrete>();
		listaLembrete = lembreteDTO.getLista(usuario1);
		
		Lembrete t1 = null;
		
		for (Lembrete tarefa : listaLembrete) {
			System.out.println(tarefa.getTitulo()+ " " + tarefa.getDescricao() + " " + tarefa.getUsuario().getNome()
					+ " " + tarefa.getData() + " " + tarefa.getHora());
			//pegando a tarefa com id 1 para alteracao
			if(tarefa.getId() == 2)
				t1 = tarefa;
		}
		//update
		if(t1 != null){
			t1.setTitulo("UPDATE teste");
			lembreteDTO.atualiza(t1);
		}
	
		
		listaLembrete = lembreteDTO.getLista(usuario1);
		
		for (Lembrete tarefa : listaLembrete) {
			System.out.println(tarefa.getTitulo()+ " " + tarefa.getDescricao() + " " + tarefa.getUsuario().getNome()
					+ " " + tarefa.getData() + " " + tarefa.getHora());

		}
		//remove
		/*if(t1 != null)
			lembreteDTO.removeEntidade(t1);
		listaLembrete = lembreteDTO.selectListaEntidadeComParametro(usuario1);
		for (Lembrete tarefa : listaLembrete) {
			System.out.println(tarefa.getTitulo()+ " " + tarefa.getDescricao() + " " + tarefa.getUsuario().getNome()
					+ " " + tarefa.getData() + " " + tarefa.getHora());
		}*/
	}

}
