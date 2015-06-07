package model;

import java.sql.Date;

public class Lembrete extends TarefaComData {
	private Date hora;
	public Lembrete(String titulo, String descricao,Usuario usuario, Date data, Date hora) {
		super(titulo, descricao, usuario, data);
		this.hora = hora;
	}
	
	public Date getHora(){
		return hora;
	}
}
