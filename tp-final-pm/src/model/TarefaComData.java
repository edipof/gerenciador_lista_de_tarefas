package model;

import java.sql.Date;

public abstract class TarefaComData extends Tarefa {
	
	private Date data;
	
	public TarefaComData(String titulo, String descricao,Usuario usuario, Date data) {
		super(titulo, descricao, usuario);
		this.data = data;
	}
	
	public Date getData(){
		return data;
	}
}
