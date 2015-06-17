package control;

import java.util.ArrayList;

import model.entidade.Lembrete;
import model.entidade.Tarefa;
import model.entidade.TarefaProgressiva;
import model.entidade.TarefaSimples;
import model.operacoesBD.ManipuladorBancoDados;
import model.operacoesBD.ManipuladorTarefaLembrete;
import model.operacoesBD.ManipuladorTarefaProgressiva;
import model.operacoesBD.ManipuladorTarefaSimples;

public class AcaoEditaTarefa {
	
	public void atualizaTarefa(Tarefa tarefa, ArrayList<String> dadosFormulario) {
		
		if (tarefa instanceof TarefaSimples) {
			
			TarefaSimples tarefaSimples = (TarefaSimples) tarefa;
			
			ManipuladorBancoDados<TarefaSimples> m = ManipuladorTarefaSimples.getInstance();
			tarefaSimples.setTitulo(dadosFormulario.get(0));
			tarefaSimples.setDescricao(dadosFormulario.get(1));
			
			m.atualizaEntidade(tarefa);
			
		} else if (tarefa instanceof TarefaProgressiva) {
			
			ManipuladorBancoDados<TarefaProgressiva> m = ManipuladorTarefaProgressiva.getInstance();
			
			TarefaProgressiva tarefaProgressiva = (TarefaProgressiva) tarefa;
			
			tarefaProgressiva.setTitulo(dadosFormulario.get(0));
			tarefaProgressiva.setDescricao(dadosFormulario.get(1));
			tarefaProgressiva.setData(dadosFormulario.get(2));
			tarefaProgressiva.setProgresso(Long.parseLong(dadosFormulario.get(3)));
			
			m.atualizaEntidade(tarefa);
			
			
			
		} else if (tarefa instanceof Lembrete) {
			
			ManipuladorBancoDados<Lembrete> m = ManipuladorTarefaLembrete.getInstance();
			
			Lembrete lembrete = (Lembrete) tarefa;
			
			lembrete.setTitulo(dadosFormulario.get(0));
			lembrete.setDescricao(dadosFormulario.get(1));
			lembrete.setData(dadosFormulario.get(2));
			lembrete.setHora(dadosFormulario.get(3));
			
			m.atualizaEntidade(tarefa);
		}
	}

}
