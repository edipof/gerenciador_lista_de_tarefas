package control;

import model.entidade.Lembrete;
import model.entidade.Tarefa;
import model.entidade.TarefaProgressiva;
import model.entidade.TarefaSimples;
import model.operacoesBD.ManipuladorBancoDados;
import model.operacoesBD.ManipuladorTarefaLembrete;
import model.operacoesBD.ManipuladorTarefaProgressiva;
import model.operacoesBD.ManipuladorTarefaSimples;

public class AcaoRemoveTarefa {

	
	public void remove(Tarefa tarefa) {
		
		if (tarefa instanceof TarefaSimples) {
			
			TarefaSimples tarefaSimples = (TarefaSimples) tarefa;
			
			ManipuladorBancoDados<TarefaSimples> m =ManipuladorTarefaSimples.getInstance();
			m.removeEntidade(tarefaSimples);
			
		} else if (tarefa instanceof TarefaProgressiva) {
			
			ManipuladorBancoDados<TarefaProgressiva> m = ManipuladorTarefaProgressiva.getInstance();
			
			TarefaProgressiva tarefaProgressiva = (TarefaProgressiva) tarefa;
			m.removeEntidade(tarefaProgressiva);
			
			
		} else if (tarefa instanceof Lembrete) {
			
			ManipuladorBancoDados<Lembrete> m = ManipuladorTarefaLembrete.getInstance();
			
			Lembrete lembrete = (Lembrete) tarefa;
			m.removeEntidade(lembrete);
			
		}
	}


}
