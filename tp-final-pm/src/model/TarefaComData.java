package model;

import java.sql.Date;

public abstract class TarefaComData extends Tarefa {
	
	private Date data;
	
	public TarefaComData(String titulo, String descricao, Date data) {
		super(titulo, descricao);
		this.data = data;
	}
	
	public Date getData(){
		return data;
	}
}
