package model.entidade;


public class Lembrete extends TarefaComData {
	private String hora;
	public Lembrete(String titulo, String descricao,Usuario usuario, String data, String hora) {
		super(titulo, descricao, usuario, data);
		this.hora = hora;
	}
	
	public String getHora(){
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
}
