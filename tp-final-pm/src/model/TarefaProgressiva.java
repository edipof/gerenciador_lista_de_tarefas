package model;


public class TarefaProgressiva extends TarefaComData {
	private long progresso;
	
	public TarefaProgressiva(String titulo, String descricao,Usuario usuario, String data, Long progresso) {
		super(titulo, descricao, usuario, data);
		this.progresso = progresso;
	}
	
	public long getProgresso(){
		return progresso;
	}
}
