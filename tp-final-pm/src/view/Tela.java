package view;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import control.AcaoEditaTarefa;
import model.Tarefa;

public class Tela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Tarefa buscaTarefaPorId (ArrayList<Tarefa> listaTarefas, String id) {
		
		Tarefa tarefa = null;
		
		for (Tarefa t : listaTarefas) {
//			System.out.println(dadosFormulario.get(0));
			if (Long.toString(t.getId()).equals(id)) {
				
				tarefa = t;
			}
    	}
		
		return tarefa;
	}

}

