package model;

import java.sql.Date;

public class TarefaProgressiva extends TarefaComData {
	private long progresso;
	
	public TarefaProgressiva(String titulo, String descricao,Usuario usuario, Date data, Long progresso) {
		super(titulo, descricao, usuario, data);
		this.progresso = progresso;
	}
	
	public long getProgresso(){
		return progresso;
	}
}
