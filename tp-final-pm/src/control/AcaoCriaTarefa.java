package control;

import model.TarefaSimples;
import model.Usuario;
import model.operacoesBD.ManipuladorBancoDados;
import model.operacoesBD.ManipuladorTarefaSimples;

public class AcaoCriaTarefa {
	
	public void insereTarefaSimples(String ts_titulo,String ts_desc){
		ManipuladorBancoDados<TarefaSimples> dao_ts = new ManipuladorTarefaSimples();
		Usuario u = new Usuario();
		u.setId(3);
		u.setNome("Bruno");
		TarefaSimples ts = new TarefaSimples(ts_titulo, ts_desc,u);
		
		 dao_ts.insereEntidade(ts,u);
	}
}
 