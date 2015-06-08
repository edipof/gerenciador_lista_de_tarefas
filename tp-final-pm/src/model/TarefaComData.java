package model;


public abstract class TarefaComData extends Tarefa {
	
	private String data;
	
	public TarefaComData(String titulo, String descricao,Usuario usuario, String data) {
		super(titulo, descricao, usuario);
		this.data = data;
	}
	
	public String getData(){
		return data;
	}
}
