package model.entidade;

import java.util.ArrayList;

public class Usuario {
	
	private long id;
	private String nome;
	private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Tarefa> getTarefas() {
		return tarefas;
	}
	
	public void setTarefas(ArrayList<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	
}
