package control;

import model.entidade.Lembrete;
import model.entidade.TarefaProgressiva;
import model.entidade.TarefaSimples;
import model.entidade.Usuario;
import model.operacoesBD.ManipuladorBancoDados;
import model.operacoesBD.ManipuladorTarefaLembrete;
import model.operacoesBD.ManipuladorTarefaProgressiva;
import model.operacoesBD.ManipuladorTarefaSimples;

public class AcaoCriaTarefa {
	private Usuario u = new Usuario();
	
	public AcaoCriaTarefa(Usuario u) {
		super();
		this.u = u;
	}

	public void insereTarefaSimples(String ts_titulo,String ts_desc){
		ManipuladorBancoDados<TarefaSimples> dao_ts = new ManipuladorTarefaSimples();
		TarefaSimples ts = new TarefaSimples(ts_titulo, ts_desc,u);
		
		 dao_ts.insereEntidade(ts,u);
	}
	
	public void insereTarefaProgressiva(String tp_titulo,String tp_desc, String tp_data, long tp_progresso){
		ManipuladorBancoDados<TarefaProgressiva> dao_tp = new ManipuladorTarefaProgressiva();
		TarefaProgressiva tp = new TarefaProgressiva(tp_titulo, tp_desc,u, tp_data, tp_progresso);
		
		 dao_tp.insereEntidade(tp,u);
	}
	
	public void insereLembrete(String l_titulo,String l_desc, String l_data, String l_hora){
		ManipuladorBancoDados<Lembrete> dao_l = new ManipuladorTarefaLembrete();
		Lembrete tl = new Lembrete(l_titulo, l_desc,u, l_data, l_hora);
		
		 dao_l.insereEntidade(tl,u);
	}
}
 