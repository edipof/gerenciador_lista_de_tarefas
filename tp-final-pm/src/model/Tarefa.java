package model;

public abstract class Tarefa {
	
	private long id;
	private String titulo;
	private String descricao;
	private Usuario usuario;
	
	public Tarefa(String titulo, String descricao, Usuario usuario) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.usuario = usuario;
	}
	
	public long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Usuario getUsuario(){
		return usuario;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
