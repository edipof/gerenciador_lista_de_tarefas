package control;

import java.util.ArrayList;

import model.Lembrete;
import model.Tarefa;
import model.TarefaProgressiva;
import model.TarefaSimples;
import model.operacoesBD.ManipuladorBancoDados;
import model.operacoesBD.ManipuladorTarefaLembrete;
import model.operacoesBD.ManipuladorTarefaProgressiva;
import model.operacoesBD.ManipuladorTarefaSimples;

public class AcaoEditaTarefa {
	
	public void atualizaTarefa(Tarefa tarefa, ArrayList<String> dadosFormulario) {
		
		if (tarefa instanceof TarefaSimples) {
			
			TarefaSimples tarefaSimples = (TarefaSimples) tarefa;
			
			ManipuladorBancoDados<TarefaSimples> m = new ManipuladorTarefaSimples();
			tarefaSimples.setTitulo(dadosFormulario.get(0));
			tarefaSimples.setDescricao(dadosFormulario.get(1));
			
			m.atualizaEntidade(tarefa);
			
		} else if (tarefa instanceof TarefaProgressiva) {
			
			ManipuladorBancoDados<TarefaProgressiva> m = new ManipuladorTarefaProgressiva();
			
			TarefaProgressiva tarefaProgressiva = (TarefaProgressiva) tarefa;
			
			tarefaProgressiva.setTitulo(dadosFormulario.get(0));
			tarefaProgressiva.setDescricao(dadosFormulario.get(1));
			tarefaProgressiva.setData(dadosFormulario.get(2));
			tarefaProgressiva.setProgresso(Long.parseLong(dadosFormulario.get(3)));
			
			m.atualizaEntidade(tarefa);
			
			
			
		} else if (tarefa instanceof Lembrete) {
			
			ManipuladorBancoDados<Lembrete> m = new ManipuladorTarefaLembrete();
			
			Lembrete lembrete = (Lembrete) tarefa;
			
			lembrete.setTitulo(dadosFormulario.get(0));
			lembrete.setDescricao(dadosFormulario.get(1));
			lembrete.setData(dadosFormulario.get(2));
			lembrete.setHora(dadosFormulario.get(3));
			
			m.atualizaEntidade(tarefa);
		}
	}
}
