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

public class AcaoRemoveTarefa {

	
	public void remove(Tarefa tarefa) {
		
		if (tarefa instanceof TarefaSimples) {
			
			TarefaSimples tarefaSimples = (TarefaSimples) tarefa;
			
			ManipuladorBancoDados<TarefaSimples> m = new ManipuladorTarefaSimples();
			m.removeEntidade(tarefaSimples);
			
		} else if (tarefa instanceof TarefaProgressiva) {
			
			ManipuladorBancoDados<TarefaProgressiva> m = new ManipuladorTarefaProgressiva();
			
			TarefaProgressiva tarefaProgressiva = (TarefaProgressiva) tarefa;
			m.removeEntidade(tarefaProgressiva);
			
			
		} else if (tarefa instanceof Lembrete) {
			
			ManipuladorBancoDados<Lembrete> m = new ManipuladorTarefaLembrete();
			
			Lembrete lembrete = (Lembrete) tarefa;
			m.removeEntidade(lembrete);
			
		}
	}


}
