package view;

import java.util.ArrayList;

import javax.swing.JFrame;

import model.entidade.Tarefa;

public class Tela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Tarefa buscaTarefaPorId (ArrayList<Tarefa> listaTarefas, String id) {
		
		Tarefa tarefa = null;
		
		for (Tarefa t : listaTarefas) {
			if (Long.toString(t.getId()).equals(id)) {
				tarefa = t;
			}
    	}
		return tarefa;
	}

}

